package memory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

    private static final Set<String> cache = new HashSet<>();
    private int counter = 0;

    private int port;
    private ServerSocket server;
    private Socket socket;
    private DataOutputStream os;
    private DataInputStream is;
    private ReentrantLock lock = new ReentrantLock();

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        server = new ServerSocket(port);
        socket = server.accept();
        os = new DataOutputStream(socket.getOutputStream());
        is = new DataInputStream(socket.getInputStream());

        while (true) {
            readMessage();
        }
    }

    private void readMessage() throws IOException {
        int count = is.readInt();
        for (int i = 0; i < count; i++) {
            int length = is.readInt();
            int bytesCapacity = 4;
            byte[] bytes = ByteBuffer.allocate(bytesCapacity).putInt(length).array();
            is.readFully(bytes);
            int index = i;
            new Thread(() -> calcSentence(bytes, index)).start();
        }
    }

    private void calcSentence(byte[] bytes, int index) {
        String str = new String(bytes).intern();
        int big = 0;
        int small = 0;
        for (String word : str.split(" ")) {
            if (word.length() <= 4) {
                cache.add(word);
                small++;
            } else {
                big++;
            }
        }
        try {
            lock.lock();
            os.writeInt(index);
            os.writeInt(big);
            os.writeInt(small);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server(7890).start();
    }
}

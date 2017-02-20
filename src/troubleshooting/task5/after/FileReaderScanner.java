package troubleshooting.task5.after;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReaderScanner {
    private static final int WORDS_QUANTITY = 3;

    public static void main(final String[] args) throws IOException, InterruptedException {
        String fileName = "Task #5 - Data.txt";
        List<String> words = getAllWords(fileName);
        System.out.println(words.subList(words.size() - WORDS_QUANTITY, words.size()));
        Thread.sleep(30000);
    }

    private static List<String> getAllWords(final String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName); Scanner sc = new Scanner(inputStream)) {
            while (sc.hasNext()) {
                words.add(sc.next());
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }
        return words.isEmpty() ? Collections.emptyList() : words;
    }
}

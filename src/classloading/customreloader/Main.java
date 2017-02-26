package classloading.customreloader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String jarName;
        if (args.length > 0) {
            jarName = args[0];
        }
        jarName = "lib/BigMath.jar";
        JarReloader jarReloader = new JarReloader(jarName);
        jarReloader.reloadJar();
    }
}

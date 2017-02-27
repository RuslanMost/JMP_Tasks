package classloading.customreloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter the path of jar file you want to reload.");
        String jarName;
        String path = br.readLine();
        if (path == null || path.isEmpty()) {
            if (args.length > 0) {
                jarName = args[0];
            } else {
                jarName = "jars/BigMath.jar";
            }
        } else {
            jarName = path;
        }

        JarReloader jarReloader = new JarReloader(jarName);
        List<Class<?>> classes = jarReloader.reloadJar();
        System.out.println(classes);
    }
}

package classloading.customreloader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarFile;

public class JarReloader {

    private static final String CLASS_EXTENSION = ".class";
    private ClassLoader parentClassLoader;
    private static final Logger LOGGER = LogManager.getLogger(JarReloader.class);
    private File file;

    public JarReloader(final String jarName, final ClassLoader parentClassLoader) {
        if (parentClassLoader == null) {
            this.parentClassLoader = this.getClass().getClassLoader();
        }
        file = new File(jarName);
    }

    public JarReloader(final String jarName) {
        this.parentClassLoader = this.getClass().getClassLoader();
        file = new File(jarName);
    }

    public List<Class<?>> reloadJar() throws IOException {
        JarFile jarFile = new JarFile(file);
        LOGGER.info("Scanning jar file - " + jarFile.getName() + " for classes to reload.");
        List<String> classesNames = new ArrayList<>();
        jarFile.stream()
                .forEach(jarEntry -> {
                    String jarEntryName = jarEntry.getName();
                    if (jarEntry.isDirectory() || !jarEntryName.endsWith(CLASS_EXTENSION)) {
                        LOGGER.info(jarEntryName + " - is not a class... ignoring.");
                    } else {
                        LOGGER.info(jarEntryName + " - will be reloaded.");
                        classesNames.add(jarEntryName);
                    }
                });
        return reloadClasses(classesNames);
    }

    private List<Class<?>> reloadClasses(final List<String> classesNames) throws MalformedURLException {
        List<Class<?>> reloadedClasses = new ArrayList<>();
        URL jarURL = file.toURI().toURL();
        try (MyUrlClassLoader urlClassLoader = new MyUrlClassLoader(new URL[]{jarURL}, parentClassLoader)) {
            classesNames.stream().forEach(jarEntryName -> {
                try {
                    reloadedClasses.add(urlClassLoader.loadClass(jarEntryName));
                    LOGGER.info(jarEntryName + " was reloaded.");
                } catch (ClassNotFoundException e) {
                    LOGGER.error(e);
                }
            });
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return reloadedClasses.isEmpty() ? Collections.emptyList() : reloadedClasses;
    }

    private class MyUrlClassLoader extends URLClassLoader {

        private static final String DOT_DELIMITER = ".";
        private static final String SLASH_DELIMITER = "/";
        private static final String EMPTY_STRING = "";
        public static final int BEGIN_INDEX = 0;

        public MyUrlClassLoader(final URL[] urls, final ClassLoader parent) {
            super(urls, parent);
        }

        @Override
        public Class<?> loadClass(final String name) throws ClassNotFoundException {
            String className = name.replaceAll(SLASH_DELIMITER, DOT_DELIMITER).replace(CLASS_EXTENSION, EMPTY_STRING);

            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                int i = className.lastIndexOf(DOT_DELIMITER);
                if (i != -1) {
                    sm.checkPackageAccess(className.substring(BEGIN_INDEX, i));
                }
            }

            //for those classes which are referenced by other classes
            if (!name.endsWith(CLASS_EXTENSION)) {
                return super.loadClass(name);
            }

            //check if a class was already loaded
            if (findLoadedClass(className) != null) {
                return findLoadedClass(className);
            }

            try {
                InputStream input = getResourceAsStream(name);
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int data = input.read();

                while (data != -1) {
                    buffer.write(data);
                    data = input.read();
                }

                input.close();
                byte[] classData = buffer.toByteArray();
                return defineClass(className, classData, 0, classData.length);
            } catch (IOException e) {
                LOGGER.error(e);
            }

            return null;
        }
    }

}

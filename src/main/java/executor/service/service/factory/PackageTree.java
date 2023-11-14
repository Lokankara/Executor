package executor.service.service.factory;

import java.io.File;
import java.util.List;

public class PackageTree {

    private PackageTree() {
    }

    public static final String ROOT_DIR = "src/main/java/";

    public static void printPackageTree(
            File directory,
            String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(indent + file.getName());
                if (file.isDirectory()) {
                    printPackageTree(file, indent + "  ");
                }
            }
        }
    }

    public static void scanDirectoryForInterfaces(
            File directory,
            List<Class<?>> interfaces) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectoryForInterfaces(file, interfaces);
                } else if (file.getName().endsWith(".java")) {
                    try {
                        String className = getClassName(file);
                        Class<?> clazz = getClassFromName(className);
                        if (clazz.isInterface()) {
                            interfaces.add(clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    private static String getClassName(File file) {
        String path = file.getPath();
        return path
                .substring(ROOT_DIR.length(), path.length() - ".java".length())
                .replace(File.separator, ".");
    }

    private static Class<?> getClassFromName(String className)
            throws ClassNotFoundException {
        ClassLoader classLoader = Thread
                .currentThread()
                .getContextClassLoader();
        return classLoader.loadClass(className);
    }
}

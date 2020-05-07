package com.jzx.thought;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 功能:遍历指定jar包中class文件名并输出到文件中
 * 第一个参数输入:jar包或者需要搜索class的目录
 * 第二个参数输入:搜索信息输出文件
 */
public class FindClassToFile {
    private static final List<String> list = new ArrayList<>();

    private static String FILE_NAME;

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            String findPath = args[0];
            FILE_NAME = args[1];
            System.out.println(">>>搜索目录或者文件:" + findPath);
            System.out.println(">>>搜索信息输出文件:" + FILE_NAME);
            if (canCreateFile(FILE_NAME)) {
                findJarFromPath(findPath);
                write(FILE_NAME);
            } else {
                System.out.println(">>>请输入正确的输出文件路径");
            }
        } else {
            System.out.println("java -jar xxx.jar directory|jar infoFile");
        }

    }

    /**
     * 创建输出文件
     *
     * @param filePath
     * @return
     */
    private static boolean canCreateFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return file.createNewFile();
            } else if (!file.isFile()) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 将信息写到文件中
     *
     * @param fileName
     */
    private static void write(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
            for (String s : list) {
                bw.write(s);
                bw.write("\n");
            }
            bw.flush();
            list.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历扫描目录或者文件(.jar后缀)
     * @param path
     * @throws IOException
     */
    private static void findJarFromPath(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        if (file.getName().endsWith(".jar")) {
            readFileFromJar(file.getCanonicalPath());
            if (list.size() > 10000) {
                write(FILE_NAME);
            }
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String ph = f.getCanonicalPath();
                System.out.println(ph);
                findJarFromPath(ph);
            }
        }

    }

    private static void readFileFromJar(String jarPath) throws IOException {
        list.add("------------------------------");
        list.add(jarPath);
        JarFile jarFile = new JarFile(jarPath);
        Enumeration<JarEntry> enumeration = jarFile.entries();
        String name;
        while (enumeration.hasMoreElements()) {
            JarEntry entry = enumeration.nextElement();
            name = entry.getName();
            if (getFalse(name)) {
                list.add(name);
            }
        }
        list.add("------------------------------");
    }

    private static boolean getFalse(String name) {
        int a = name.lastIndexOf(".");
        int b = name.lastIndexOf("/");
        if (a < b) {
            return false;
        }
        return true;
    }
}

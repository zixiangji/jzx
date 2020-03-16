package com.sdsc.myThought;

import java.io.File;

/**
 * 扫描指定目录下的文件或者目录
 */
public class ScanFile {

    public static void main(String[] args) {
        File src;
        if (args.length == 1) {
            try {
                src = new File(args[0]);
                send(src, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("请输入相应目录");
        }
    }

    private static void send(File file, int depth) {
        if (file.exists() && file.isDirectory()) {
            System.out.printf(head(depth) + "%s", file.getName());
            System.out.println();
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {

                    send(f, depth + 1);
                }
            }
        } else {
            System.out.printf(head(depth) + "%s", file.getName());
            System.out.println();
        }
    }

    /**
     * 得到深度
     *
     * @param depth
     * @return
     */
    private static String head(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append("|__");
        return sb.toString();
    }
}

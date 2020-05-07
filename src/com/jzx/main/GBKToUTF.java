package com.sdsc.main;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GBKToUTF {
    public static void main(String[] args) throws IOException {
        String srcFile = "./12316.txt";
        String dstFile = "./12317.txt";
        gbkToUTF8(srcFile, dstFile);
    }

    public static void gbkToUTF8(String srcFile, String dstFile) throws IOException {
        File f = new File(srcFile);
        FileInputStream fin = new FileInputStream(f);
        BufferedReader br = new BufferedReader(new InputStreamReader(fin, "GBK"));
        // 以UTF-8格式写入文件,file.getAbsolutePath()即该文件的绝对路径,false代表不追加直接覆盖,true代表追加文件
        FileOutputStream fos = new FileOutputStream(dstFile, false);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        String line = br.readLine();
        while (line != null) {
            osw.write(line);
            osw.write("\n");
            line = br.readLine();
        }
        osw.flush();

        fos.close();
        osw.close();
    }
}

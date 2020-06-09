package com.jzx.basic.file;

import java.io.InputStream;
import java.util.Properties;

public class FilePath {
    public static String getProjectPath() {
        return System.getProperty("user.dir") + "/";
    }

    public static String getSrcPathAgerRun() {
        return System.getProperty("user.dir") + "/bin";
    }

    private static void readCurrent() {
        try {
            InputStream in = FilePath.class.getResourceAsStream("/a.properties");
            Properties properties = new Properties();
            properties.load(in);

            System.out.println(properties.getProperty("name"));
            System.out.println(properties.getProperty("password"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readCurrent();
        System.out.println(getProjectPath());
        System.out.println(getSrcPathAgerRun());
    }
}

package com.jzx.basic.file;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class FilePath {
    private static String getProjectPath() {
        // 运行jar包的命令所在的目录，如果是在/root目录下java -jar /home/test.jar的话，
        // 此方法返回的是/root，这个一定要注意
        return System.getProperty("user.dir") + "/";
    }

    /**
     * 读取jar包里面的配置文件
     */
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

    private static void readFileFirst() {
        try {
            File file = new File("./yy.ftl");
            System.out.println("./yy.ftl文件情况" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void readFileSecond() {
        try {
            File file = new File("../yy.ftl");
            System.out.println("../yy.ftl文件情况" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void readFileThree() {
        try {
            File file = new File("/yy.ftl");
            System.out.println("/yy.ftl文件情况" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void readFileFour() {
        try {
            File file = new File("yy.ftl");
            System.out.println("yy.ftl文件情况" + file.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readCurrent();
        System.out.println(getProjectPath());

        readFileFirst();
        readFileSecond();
        readFileThree();
        readFileFour();

    }
}

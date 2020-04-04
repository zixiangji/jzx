package com.sdsc.basic.file;

public class FilePath {
    /**
     * current project path
     *
     * @return
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir") + "/";
    }

    public static String getSrcPathAgerRun() {
        return System.getProperty("user.dir") + "/bin";
    }

    public static String getPackgePath() {
        String thisPackPath = FilePath.class.getResource("").toString();
        int m = thisPackPath.indexOf("/");
        thisPackPath = thisPackPath.substring(m + 1);
        return thisPackPath;
    }

    //
    public static String getClassLoaderPath() {
        String path = FilePath.class.getClassLoader().getResource("").toString();
        return path;
    }

    public static void main(String[] args) {
        System.out.println(getProjectPath());
        System.out.println(getPackgePath());
        System.out.println(getClassLoaderPath());
    }
}

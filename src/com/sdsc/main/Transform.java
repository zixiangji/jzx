package com.sdsc.main;

public class Transform {


    public static void keyword() {
        int n = 107;
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));

        System.out.println(Integer.bitCount(n));
    }

    public static void main(String[] args) {
        keyword();
    }
}

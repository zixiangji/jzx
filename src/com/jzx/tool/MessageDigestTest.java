package com.sdsc.tool;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
    private static MessageDigest MD5 = null;

    static {
        try {
            MD5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MD5.digest(
                    plainText.getBytes());
            String md5code = new BigInteger(1, secretBytes).toString(16);
            for (int i = 0; i < 32 - md5code.length(); i++) {
                md5code = "0" + md5code;
            }
            return md5code;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // 在spring中也可以使用这个
        // org.springframework.util.DigestUtils.md5DigestAsHex("1234".getBytes())
        String value = stringToMD5("123456");
        System.out.println(value);
        //e10adc3949ba59abbe56e057f20f883e
        //e10adc3949ba59abbe56e057f20f883e
    }
}

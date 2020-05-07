package com.jzx.thought;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

/**
 * 图片转base64，base64转图片
 */
public class ImageAndBase64 {
    public static String imageToBase64(String src) throws IOException {
        File file = new File(src);
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static File base64ToImage(String base64Str, String dstFile) throws IOException {
        byte[] bytes = Base64.getDecoder().decode(base64Str);
        ByteArrayInputStream byteArrInputGlobal = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage = ImageIO.read(byteArrInputGlobal);
        File file = new File(dstFile);
        ImageIO.write(bufferedImage, "jpg", file);
        return file;
    }

    public static void main(String[] args) throws Exception {
        String src = "c:/jmeter/2.jpg";
        String base64  = imageToBase64(src);
        System.out.println(base64);
        File f = base64ToImage(base64,"c:/2020/1.jpg");
    }

}

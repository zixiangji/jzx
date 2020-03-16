package com.sdsc.myThought;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 压缩图片
 */
public class CompressImage {
    public static void main(String[] args) {
        if (args.length != 4) {
            String srcPath = args[0];
            String dstPath = args[1];
            int width = Integer.parseInt(args[2]);
            int height = Integer.parseInt(args[3]);
            File srcFile = new File(srcPath);
            if (!srcFile.isFile()) {
                System.out.println("不是文件");
                return;
            }
            System.out.println("压缩图片开始...");
            System.out.println("压缩前文件大小:" + srcFile.length());
            reduceImg(srcPath, dstPath, width, height, null);
            File distFile = new File(dstPath);
            System.out.println("压缩后文件大小:" + distFile.length());
        }
    }

    /**
     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩
     *
     * @param imgSrc     源图片地址
     * @param imgDist    目标图片地址
     * @param widthDist  压缩后图片宽度（当rate==null时，必传）
     * @param heightDist 压缩后图片高度（当rate==null时，必传）
     * @param rate       压缩比例
     */
    public static void reduceImg(String imgSrc, String imgDist, int widthDist,
                                 int heightDist, Float rate) {
        try {
            File srcfile = new File(imgSrc);
            // 检查文件是否存在
            if (!srcfile.exists()) {
                return;
            }
            // 如果rate不为空说明是按比例压缩
            if (rate != null && rate > 0) {
                // 获取文件高度和宽度
                int[] results = getImgWidth(srcfile);
                if (results == null || results[0] == 0 || results[1] == 0) {
                    return;
                } else {
                    widthDist = (int) (results[0] * rate);
                    heightDist = (int) (results[1] * rate);
                }
            }
            // 开始读取文件并进行压缩
            Image src = javax.imageio.ImageIO.read(srcfile);
            BufferedImage tag = new BufferedImage(widthDist, heightDist, BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(
                    src.getScaledInstance(widthDist, heightDist, Image.SCALE_SMOOTH), 0, 0, null);

            FileOutputStream out = new FileOutputStream(imgDist);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //BufferedImage转流
    public ByteArrayOutputStream image2Stream(BufferedImage image) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out;
    }

    //BufferedImage转byte[]
    public byte[] image2byte(BufferedImage image) {
        ByteArrayOutputStream out = image2Stream(image);
        byte[] outToByteArray = out.toByteArray();
        return outToByteArray;
    }

    /**
     * 获取图片宽度
     *
     * @param file 图片文件
     * @return 宽度
     */
    public static int[] getImgWidth(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = {0, 0};
        try {
            is = new FileInputStream(file);
            src = javax.imageio.ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图宽
            result[1] = src.getHeight(null); // 得到源图高
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

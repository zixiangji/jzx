package com.jzx.tool;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * 使用开源工具进行图片处理
 */
public class ThumbnailTest {
    public static void main(String[] args) throws IOException {
        // 样例展示 https://github.com/coobird/thumbnailator/wiki/Examples
        // 基本用法
        Thumbnails.of(new File("C:\\2020\\1.png"))
                .size(160, 160).toFile(new File("C:\\2020\\2.png"));
        // 旋转和水印
//        Thumbnails.of(new File("original.jpg"))
//                .size(160, 160)
//                .rotate(90)
//                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("watermark.png")), 0.5f)
//                .outputQuality(0.8)
//                .toFile(new File("image-with-watermark.jpg"));
    }
}

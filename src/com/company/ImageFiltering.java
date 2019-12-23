package com.company;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

public class ImageFiltering {

    public static void blueStaticFilter(File input, File output) {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(input);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            ImageReader reader = iterator.next();
            String imageFormat = reader.getFormatName();

            BufferedImage img = ImageIO.read(iis);
            int height = img.getHeight();
            int width = img.getWidth();

            Random rand = new Random();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    short b = (short)rand.nextInt(255);
                    img.setRGB(x, y, b);
                }
            }
            ImageIO.write(img, imageFormat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected static void toGrayScale(File input, File output) {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(input);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            ImageReader reader = iterator.next();
            String imageFormat = reader.getFormatName();

            BufferedImage img = ImageIO.read(iis);
            int height = img.getHeight();
            int width = img.getWidth();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width / 2; x++) {
                    Color color = new Color(img.getRGB(x, y));
                    int red = (int) (color.getRed() * 0.2162);
                    int blue = (int) (color.getBlue() * 0.0722);
                    int green = (int) (color.getGreen() * 0.7152);
                    int sum = red + blue + green;
                    Color grayScale = new Color(sum, sum, sum);
                    img.setRGB(x, y, grayScale.getRGB());
                }
            }
            ImageIO.write(img, imageFormat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
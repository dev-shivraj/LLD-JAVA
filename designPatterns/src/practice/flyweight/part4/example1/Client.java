package practice.flyweight.part4.example1;

import practice.flyweight.part4.example1.extrinsic.Image;
import practice.flyweight.part4.example1.factory.ImageTypeFactory;
import practice.flyweight.part4.example1.intrinsic.ImageType;

public class Client {

    public static void main(String[] args) {

        ImageTypeFactory factory = new ImageTypeFactory();

        ImageType jpeg = factory.getImageType("JPEG", "HIGH", "STANDARD");
        ImageType jpegAgain = factory.getImageType("JPEG", "HIGH", "STANDARD");
        ImageType png = factory.getImageType("PNG", "LOSSLESS", "STANDARD");

        Image image1 = new Image("photo1.jpg", 1024, jpeg);
        Image image2 = new Image("photo2.jpg", 2048, jpegAgain);
        Image image3 = new Image("logo.png", 4096, png);

        image1.process();
        image2.process();
        image3.process();

        System.out.println();
        System.out.println("jpeg == jpegAgain: " + (jpeg == jpegAgain));
        System.out.println("jpeg == png: " + (jpeg == png));
    }
}
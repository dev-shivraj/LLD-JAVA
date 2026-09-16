package practice.flyweight.part4.example1.extrinsic;

import practice.flyweight.part4.example1.intrinsic.ImageType;

public class Image {

    private final String fileName;
    private final long size;
    private final ImageType imageType;

    public Image(String fileName, long size, ImageType imageType) {
        this.fileName = fileName;
        this.size = size;
        this.imageType = imageType;
    }

    public void process() {
        imageType.process(fileName, size);
    }

    public ImageType getImageType() {
        return imageType;
    }
}
package practice.flyweight.part4.example1.factory;

import practice.flyweight.part4.example1.intrinsic.ImageType;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ImageTypeFactory {

    private final ConcurrentMap<String, ImageType> imageTypes = new ConcurrentHashMap<>();

    public ImageType getImageType(String format, String compression, String metadataProfile) {
        String key = format + "_" + compression + "_" + metadataProfile;
        return imageTypes.computeIfAbsent(key, ignored -> new ImageType(format, compression, metadataProfile));
    }
}
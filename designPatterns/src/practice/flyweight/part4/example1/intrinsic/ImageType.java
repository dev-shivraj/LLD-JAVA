package practice.flyweight.part4.example1.intrinsic;

public class ImageType {

    private final String format;
    private final String compression;
    private final String metadataProfile;

    public ImageType(
            String format,
            String compression,
            String metadataProfile
    ) {
        this.format = format;
        this.compression = compression;
        this.metadataProfile = metadataProfile;
    }

    public void process(String fileName, long size) {
        System.out.println(
                "Processing " + fileName +
                " | Size: " + size +
                " | Format: " + format +
                " | Compression: " + compression +
                " | Metadata: " + metadataProfile
        );
    }
}
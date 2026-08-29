package practice.dip.part1.cloudStorage.goodDesign;

public class AmazonS3Storage implements Storage {
    @Override
    public void upload() {
        System.out.println("Uploading to Amazon S3");
    }
}
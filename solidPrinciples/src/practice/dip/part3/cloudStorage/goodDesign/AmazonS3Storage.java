package practice.dip.part3.cloudStorage.goodDesign;

public class AmazonS3Storage implements Storage {

    @Override
    public void upload(String file) {
        System.out.println(
                "Uploading " + file + " to Amazon S3"
        );
    }
}
package practice.dip.part3.cloudStorage.badDesign;

public class AmazonS3Storage {

    public void upload(String file) {
        System.out.println("Uploading " + file + " to Amazon S3");
    }
}
package practice.ocp.part3.cloudStorage.goodDesign;

public class S3StorageProvider implements StorageProvider {

    @Override
    public void upload(String file) {
        System.out.println("Uploading to Amazon S3: " + file);
    }
}
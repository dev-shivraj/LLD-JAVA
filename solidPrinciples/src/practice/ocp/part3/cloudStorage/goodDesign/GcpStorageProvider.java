package practice.ocp.part3.cloudStorage.goodDesign;

public class GcpStorageProvider implements StorageProvider {

    @Override
    public void upload(String file) {
        System.out.println("Uploading to Google Cloud Storage: " + file);
    }
}
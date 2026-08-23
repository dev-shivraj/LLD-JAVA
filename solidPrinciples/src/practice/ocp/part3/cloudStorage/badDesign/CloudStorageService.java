package practice.ocp.part3.cloudStorage.badDesign;

public class CloudStorageService {

    public void upload(String storageType, String file) {

        if (storageType.equals("S3")) {
            System.out.println("Uploading to Amazon S3: " + file);
        } else if (storageType.equals("AZURE")) {
            System.out.println("Uploading to Azure Blob: " + file);
        } else if (storageType.equals("GCP")) {
            System.out.println("Uploading to Google Cloud Storage: " + file);
        }
    }
}
package practice.ocp.part3.cloudStorage.goodDesign;

public class AzureStorageProvider implements StorageProvider {

    @Override
    public void upload(String file) {
        System.out.println("Uploading to Azure Blob Storage: " + file);
    }
}
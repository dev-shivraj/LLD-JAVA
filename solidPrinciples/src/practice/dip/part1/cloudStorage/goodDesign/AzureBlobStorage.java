package practice.dip.part1.cloudStorage.goodDesign;

public class AzureBlobStorage implements Storage {
    @Override
    public void upload() {
        System.out.println("Uploading to Azure Blob Storage");
    }
}
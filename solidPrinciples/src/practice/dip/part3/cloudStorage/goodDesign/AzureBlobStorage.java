package practice.dip.part3.cloudStorage.goodDesign;

public class AzureBlobStorage implements Storage {

    @Override
    public void upload(String file) {
        System.out.println(
                "Uploading " + file + " to Azure Blob Storage"
        );
    }
}
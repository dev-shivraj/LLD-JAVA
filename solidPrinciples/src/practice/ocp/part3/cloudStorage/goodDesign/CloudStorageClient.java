package practice.ocp.part3.cloudStorage.goodDesign;

public class CloudStorageClient {

    public static void main(String[] args) {

        CloudStorageService s3Service =
                new CloudStorageService(
                        new S3StorageProvider(),
                        new AesEncryption()
                );

        s3Service.upload("photo.jpg");

        System.out.println("----------------");

        CloudStorageService azureService =
                new CloudStorageService(
                        new AzureStorageProvider(),
                        new NoEncryption()
                );

        azureService.upload("document.pdf");

        System.out.println("----------------");

        CloudStorageService gcpService =
                new CloudStorageService(
                        new GcpStorageProvider(),
                        new RsaEncryption()
                );

        gcpService.upload("backup.zip");
    }
}
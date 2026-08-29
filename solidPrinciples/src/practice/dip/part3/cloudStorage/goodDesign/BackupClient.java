package practice.dip.part3.cloudStorage.goodDesign;

public class BackupClient {

    public static void main(String[] args) {

        Storage storage =
                new AmazonS3Storage();

        Encryption encryption =
                new AESEncryption();

        Notification notification =
                new EmailNotification();

        BackupService service =
                new BackupService(
                        storage,
                        encryption,
                        notification
                );

        service.backup("data.txt");

        System.out.println("----------------");

        storage =
                new AzureBlobStorage();

        encryption =
                new RSAEncryption();

        notification =
                new SMSNotification();

        service =
                new BackupService(
                        storage,
                        encryption,
                        notification
                );

        service.backup("backup.zip");
    }
}
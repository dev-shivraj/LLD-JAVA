package practice.dip.part3.cloudStorage.badDesign;

public class BackupService {

    private final AmazonS3Storage storage =
            new AmazonS3Storage();

    private final AESEncryption encryption =
            new AESEncryption();

    private final EmailNotification notification =
            new EmailNotification();

    public void backup(String file) {

        String encryptedFile =
                encryption.encrypt(file);

        storage.upload(encryptedFile);

        notification.send(
                "Backup completed for " + file
        );
    }
}
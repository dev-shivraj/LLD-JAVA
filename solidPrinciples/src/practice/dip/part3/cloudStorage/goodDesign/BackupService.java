package practice.dip.part3.cloudStorage.goodDesign;

public class BackupService {

    private final Storage storage;
    private final Encryption encryption;
    private final Notification notification;

    public BackupService(
            Storage storage,
            Encryption encryption,
            Notification notification) {

        this.storage = storage;
        this.encryption = encryption;
        this.notification = notification;
    }

    public void backup(String file) {

        String encryptedFile =
                encryption.encrypt(file);

        storage.upload(encryptedFile);

        notification.send(
                "Backup completed for " + file
        );
    }
}
package practice.ocp.part3.cloudStorage.goodDesign;

public class CloudStorageService {

    private final StorageProvider storageProvider;
    private final Encryption encryption;

    public CloudStorageService(StorageProvider storageProvider,
                               Encryption encryption) {
        this.storageProvider = storageProvider;
        this.encryption = encryption;
    }

    public void upload(String file) {
        String encryptedFile = encryption.encrypt(file);
        storageProvider.upload(encryptedFile);
    }
}
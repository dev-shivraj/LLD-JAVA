package practice.lsp.part3.cloudStorage.badDesign;

public class LocalStorage extends CloudStorage {
    @Override
    public void encrypt(String fileName) {
        throw new UnsupportedOperationException("Local storage does not support this encryption");
    }
}
package practice.lsp.part3.cloudStorage.badDesign;

public class CloudStorage {
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName);
    }

    public void download(String fileName) {
        System.out.println("Downloading " + fileName);
    }

    public void encrypt(String fileName) {
        System.out.println("Encrypting " + fileName);
    }
}
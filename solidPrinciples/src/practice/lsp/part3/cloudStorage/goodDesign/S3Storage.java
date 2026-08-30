package practice.lsp.part3.cloudStorage.goodDesign;

public class S3Storage implements Storage, Encryption {
    @Override
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " to S3");
    }

    @Override
    public void download(String fileName) {
        System.out.println("Downloading " + fileName + " from S3");
    }

    @Override
    public void encrypt(String fileName) {
        System.out.println("Encrypting " + fileName);
    }
}
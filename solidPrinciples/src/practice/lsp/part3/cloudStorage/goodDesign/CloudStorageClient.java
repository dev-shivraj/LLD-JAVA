package practice.lsp.part3.cloudStorage.goodDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        Storage localStorage = new LocalStorage();
        localStorage.upload("file.txt");
        localStorage.download("file.txt");
        System.out.println("----------------");

        S3Storage s3Storage = new S3Storage();
        s3Storage.upload("file.txt");
        s3Storage.download("file.txt");
        s3Storage.encrypt("file.txt");
    }
}
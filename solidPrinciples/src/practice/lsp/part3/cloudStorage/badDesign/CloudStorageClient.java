package practice.lsp.part3.cloudStorage.badDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        CloudStorage storage = new LocalStorage();
        storage.upload("file.txt");
        storage.download("file.txt");
        storage.encrypt("file.txt");
    }
}
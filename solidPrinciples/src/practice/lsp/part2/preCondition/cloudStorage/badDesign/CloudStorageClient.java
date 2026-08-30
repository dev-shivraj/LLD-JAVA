package practice.lsp.part2.preCondition.cloudStorage.badDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        CloudStorage storage = new S3Storage();
        storage.upload("document.pdf");
    }
}
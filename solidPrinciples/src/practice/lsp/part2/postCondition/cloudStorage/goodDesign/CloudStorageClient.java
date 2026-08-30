package practice.lsp.part2.postCondition.cloudStorage.goodDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        CloudStorage storage = new S3Storage();
        boolean uploaded = storage.upload("document.pdf");
        System.out.println("Uploaded: " + uploaded);
    }
}
package practice.lsp.part2.invariants.cloudStorage.goodDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        CloudStorage storage = new S3Storage();
        storage.deleteFile(500);
        System.out.println("Used storage: " + storage.getUsedStorage());
    }
}
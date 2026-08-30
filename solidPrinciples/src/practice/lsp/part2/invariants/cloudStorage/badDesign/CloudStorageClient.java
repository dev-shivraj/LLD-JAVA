package practice.lsp.part2.invariants.cloudStorage.badDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        CloudStorage storage = new S3Storage();
        storage.deleteFile(1000);
        System.out.println("Used storage: " + storage.getUsedStorage());
    }
}
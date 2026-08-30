package practice.lsp.part2.invariants.cloudStorage.badDesign;

public class S3Storage extends CloudStorage {
    @Override
    public void deleteFile(long fileSize) {
        usedStorage -= fileSize * 2;
        System.out.println("File deleted from S3");
    }
}
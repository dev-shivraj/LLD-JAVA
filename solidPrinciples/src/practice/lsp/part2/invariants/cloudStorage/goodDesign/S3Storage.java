package practice.lsp.part2.invariants.cloudStorage.goodDesign;

public class S3Storage extends CloudStorage {
    @Override
    public void deleteFile(long fileSize) {
        if (fileSize <= 0 || fileSize > usedStorage) {
            throw new IllegalArgumentException("Invalid file size");
        }

        usedStorage -= fileSize;
        System.out.println("File deleted from S3");
    }
}
package practice.lsp.part2.invariants.cloudStorage.goodDesign;

public class CloudStorage {
    protected long usedStorage = 1000;

    public void deleteFile(long fileSize) {
        if (fileSize <= 0 || fileSize > usedStorage) {
            throw new IllegalArgumentException("Invalid file size");
        }

        usedStorage -= fileSize;
    }

    public long getUsedStorage() {
        return usedStorage;
    }
}
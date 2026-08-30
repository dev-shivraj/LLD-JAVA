package practice.lsp.part1.cloudStorage.badDesign;

public class S3Storage extends CloudStorage {
    @Override
    public void delete(String file) {
        System.out.println("Deleting " + file + " from S3");
    }
}
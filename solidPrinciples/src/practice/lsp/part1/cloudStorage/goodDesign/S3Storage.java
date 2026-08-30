package practice.lsp.part1.cloudStorage.goodDesign;

public class S3Storage extends DeletableStorage {
    @Override
    public void delete(String file) {
        System.out.println("Deleting " + file + " from S3");
    }
}
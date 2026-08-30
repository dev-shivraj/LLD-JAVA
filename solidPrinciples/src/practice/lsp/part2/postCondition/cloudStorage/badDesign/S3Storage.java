package practice.lsp.part2.postCondition.cloudStorage.badDesign;

public class S3Storage extends CloudStorage {
    @Override
    public boolean upload(String fileName) {
        System.out.println("S3 upload requested");
        return false;
    }
}
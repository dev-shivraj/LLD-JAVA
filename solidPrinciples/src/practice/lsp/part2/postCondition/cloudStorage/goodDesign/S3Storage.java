package practice.lsp.part2.postCondition.cloudStorage.goodDesign;

public class S3Storage extends CloudStorage {
    @Override
    public boolean upload(String fileName) {
        System.out.println("Uploading " + fileName + " to S3");
        return true;
    }
}
package practice.lsp.part2.preCondition.cloudStorage.badDesign;

public class S3Storage extends CloudStorage {
    @Override
    public void upload(String fileName) {
        if (fileName == null || !fileName.endsWith(".zip")) {
            throw new IllegalArgumentException("S3 accepts only ZIP files");
        }

        System.out.println("File uploaded to S3: " + fileName);
    }
}
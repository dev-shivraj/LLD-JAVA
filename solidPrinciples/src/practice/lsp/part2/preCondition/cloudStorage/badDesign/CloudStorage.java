package practice.lsp.part2.preCondition.cloudStorage.badDesign;

public class CloudStorage {
    public void upload(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }

        System.out.println("File uploaded: " + fileName);
    }
}
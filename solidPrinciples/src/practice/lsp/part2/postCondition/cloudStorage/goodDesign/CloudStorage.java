package practice.lsp.part2.postCondition.cloudStorage.goodDesign;

public class CloudStorage {
    public boolean upload(String fileName) {
        System.out.println("Uploading " + fileName);
        return true;
    }
}
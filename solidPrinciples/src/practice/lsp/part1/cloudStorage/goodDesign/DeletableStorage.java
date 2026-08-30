package practice.lsp.part1.cloudStorage.goodDesign;

public class DeletableStorage extends CloudStorage {
    public void delete(String file) {
        System.out.println("Deleting " + file);
    }
}
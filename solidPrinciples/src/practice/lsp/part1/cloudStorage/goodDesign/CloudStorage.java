package practice.lsp.part1.cloudStorage.goodDesign;

public class CloudStorage {
    public void upload(String file) {
        System.out.println("Uploading " + file);
    }

    public void download(String file) {
        System.out.println("Downloading " + file);
    }
}
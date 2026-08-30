package practice.lsp.part1.cloudStorage.badDesign;

public class CloudStorage {
    public void upload(String file) {
        System.out.println("Uploading " + file);
    }

    public void download(String file) {
        System.out.println("Downloading " + file);
    }

    public void delete(String file) {
        System.out.println("Deleting " + file);
    }
}
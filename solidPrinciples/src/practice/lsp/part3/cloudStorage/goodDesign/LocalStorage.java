package practice.lsp.part3.cloudStorage.goodDesign;

public class LocalStorage implements Storage {
    @Override
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " locally");
    }

    @Override
    public void download(String fileName) {
        System.out.println("Downloading " + fileName + " locally");
    }
}
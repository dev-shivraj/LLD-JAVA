package practice.lsp.part3.cloudStorage.goodDesign;

public interface Storage {
    void upload(String fileName);

    void download(String fileName);
}
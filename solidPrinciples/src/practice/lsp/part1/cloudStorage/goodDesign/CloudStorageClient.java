package practice.lsp.part1.cloudStorage.goodDesign;

public class CloudStorageClient {
    public static void uploadFile(CloudStorage storage, String file) {
        storage.upload(file);
    }

    public static void deleteFile(DeletableStorage storage, String file) {
        storage.delete(file);
    }

    public static void main(String[] args) {
        CloudStorage readOnly = new ReadOnlyStorage();
        uploadFile(readOnly, "data.txt");

        DeletableStorage s3 = new S3Storage();
        uploadFile(s3, "data.txt");
        deleteFile(s3, "data.txt");
    }
}
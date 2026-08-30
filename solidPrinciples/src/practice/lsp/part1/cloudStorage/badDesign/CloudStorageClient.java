package practice.lsp.part1.cloudStorage.badDesign;

public class CloudStorageClient {
    public static void deleteFile(CloudStorage storage, String file) {
        storage.delete(file);
    }

    public static void main(String[] args) {
        CloudStorage s3 = new S3Storage();
        deleteFile(s3, "data.txt");

        CloudStorage readOnly = new ReadOnlyStorage();
        deleteFile(readOnly, "data.txt");
    }
}
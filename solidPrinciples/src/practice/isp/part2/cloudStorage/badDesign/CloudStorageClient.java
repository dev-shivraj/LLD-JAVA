package practice.isp.part2.cloudStorage.badDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        CloudStorage storage = new BasicCloudStorage();
        storage.upload();
        storage.download();
        storage.delete();

        storage.generatePublicUrl();
        storage.streamVideo();
    }
}
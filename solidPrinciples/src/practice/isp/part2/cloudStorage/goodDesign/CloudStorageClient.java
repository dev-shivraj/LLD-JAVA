package practice.isp.part2.cloudStorage.goodDesign;

public class CloudStorageClient {
    public static void main(String[] args) {
        Storage storage = new BasicCloudStorage();
        storage.upload();
        storage.download();
        storage.delete();
        System.out.println("----------------");

        Storage advancedStorage = new AdvancedCloudStorage();
        advancedStorage.upload();
        advancedStorage.download();
        advancedStorage.delete();
        System.out.println("----------------");

        PublicUrlGenerator urlGenerator = new AdvancedCloudStorage();
        urlGenerator.generatePublicUrl();
        System.out.println("----------------");

        VideoStreamer videoStreamer = new AdvancedCloudStorage();
        videoStreamer.streamVideo();
    }
}
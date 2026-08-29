package practice.isp.part1.cloudStorage.badDesign;

public class Client {
    public static void main(String[] args) {
        BasicCloudStorage basicCloudStorage = new BasicCloudStorage();
        basicCloudStorage.upload();
        basicCloudStorage.download();
        basicCloudStorage.delete();
        basicCloudStorage.generatePublicUrl();
        basicCloudStorage.streamVideo();
    }
}

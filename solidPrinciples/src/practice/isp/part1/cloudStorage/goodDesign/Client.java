package practice.isp.part1.cloudStorage.goodDesign;

public class Client {
    public static void main(String[] args) {
        BasicCloudStorage basicCloudStorage = new BasicCloudStorage();
        basicCloudStorage.upload();
        basicCloudStorage.download();
        basicCloudStorage.delete();


        System.out.println();
        AdvanceCloudStorage advanceCloudStorage = new AdvanceCloudStorage();
        advanceCloudStorage.upload();
        advanceCloudStorage.download();
        advanceCloudStorage.delete();
        advanceCloudStorage.generatePublicUrl();
        advanceCloudStorage.streamVideo();
    }
}

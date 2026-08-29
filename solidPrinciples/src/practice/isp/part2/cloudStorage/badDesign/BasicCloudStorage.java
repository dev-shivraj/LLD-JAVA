package practice.isp.part2.cloudStorage.badDesign;

public class BasicCloudStorage implements CloudStorage {

    @Override
    public void upload() {
        System.out.println("Uploading file");
    }

    @Override
    public void download() {
        System.out.println("Downloading file");
    }

    @Override
    public void delete() {
        System.out.println("Deleting file");
    }

    @Override
    public void generatePublicUrl() {
        System.out.println("Public URL not supported");
    }

    @Override
    public void streamVideo() {
        System.out.println("Video streaming not supported");
    }
}
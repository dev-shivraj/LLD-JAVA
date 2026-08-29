package practice.isp.part1.cloudStorage.badDesign;

public class BasicCloudStorage implements CloudStorage{
    @Override
    public void upload() {
        System.out.println("Uploading...");
    }

    @Override
    public void download() {
        System.out.println("Downloading...");
    }

    @Override
    public void delete() {
        System.out.println("Deleting...");
    }

    @Override
    public void generatePublicUrl() {
        System.out.println("BasicCloudStorage doesn't support generating public url");
    }

    @Override
    public void streamVideo() {
        System.out.println("BasicCloudStorage doesn't support streaming video");
    }
}

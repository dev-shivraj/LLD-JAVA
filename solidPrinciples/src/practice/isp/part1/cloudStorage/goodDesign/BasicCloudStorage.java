package practice.isp.part1.cloudStorage.goodDesign;

public class BasicCloudStorage implements CloudStorage {
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
}

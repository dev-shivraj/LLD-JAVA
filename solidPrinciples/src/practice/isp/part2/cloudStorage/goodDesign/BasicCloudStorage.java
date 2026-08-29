package practice.isp.part2.cloudStorage.goodDesign;

public class BasicCloudStorage implements Storage {
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
}
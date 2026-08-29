package practice.dip.part1.cloudStorage.goodDesign;

public class GCPStorage implements Storage {
    @Override
    public void upload() {
        System.out.println("Uploading to Google Cloud Storage");
    }
}
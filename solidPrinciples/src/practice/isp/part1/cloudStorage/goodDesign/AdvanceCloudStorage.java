package practice.isp.part1.cloudStorage.goodDesign;

public class AdvanceCloudStorage implements CloudStorage, PublicUrlGenerator, VideoStreamer {
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
        System.out.println("Generating public URL");
    }

    @Override
    public void streamVideo() {
        System.out.println("Streaming Video");
    }
}

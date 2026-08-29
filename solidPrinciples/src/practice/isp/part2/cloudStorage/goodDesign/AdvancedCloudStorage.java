package practice.isp.part2.cloudStorage.goodDesign;

public class AdvancedCloudStorage implements Storage, PublicUrlGenerator, VideoStreamer {
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
        System.out.println("Generating public URL");
    }

    @Override
    public void streamVideo() {
        System.out.println("Streaming video");
    }
}
package practice.isp.part1.cloudStorage.badDesign;

public interface CloudStorage {
    void upload();
    void download();
    void delete();
    void generatePublicUrl();
    void streamVideo();
}

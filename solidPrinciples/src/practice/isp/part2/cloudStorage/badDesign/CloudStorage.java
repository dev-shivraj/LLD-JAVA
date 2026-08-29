package practice.isp.part2.cloudStorage.badDesign;

public interface CloudStorage {
    void upload();
    void download();
    void delete();
    void generatePublicUrl();
    void streamVideo();
}
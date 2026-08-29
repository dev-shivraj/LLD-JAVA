package practice.isp.part2.cloudStorage.goodDesign;

public interface Storage {
    void upload();
    void download();
    void delete();
}
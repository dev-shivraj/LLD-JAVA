package practice.dip.part1.media.badDesign;

public class MediaClient {
    public static void main(String[] args) {
        MediaService service = new MediaService();
        service.playMedia();
    }
}
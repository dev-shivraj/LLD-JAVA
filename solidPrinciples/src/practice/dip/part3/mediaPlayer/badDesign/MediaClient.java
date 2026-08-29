package practice.dip.part3.mediaPlayer.badDesign;

public class MediaClient {
    public static void main(String[] args) {
        MediaService service = new MediaService();
        service.playMedia();
    }
}
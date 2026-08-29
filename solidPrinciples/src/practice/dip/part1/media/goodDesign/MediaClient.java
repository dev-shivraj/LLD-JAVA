package practice.dip.part1.media.goodDesign;

public class MediaClient {
    public static void main(String[] args) {
        MediaPlayer player = new SpotifyPlayer();
        MediaService service = new MediaService(player);

        service.playMedia();
        System.out.println("----------------");

        player = new VLCPlayer();
        service = new MediaService(player);
        service.playMedia();
    }
}
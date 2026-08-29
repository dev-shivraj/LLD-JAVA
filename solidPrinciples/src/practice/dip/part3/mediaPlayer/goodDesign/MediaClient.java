package practice.dip.part3.mediaPlayer.goodDesign;

public class MediaClient {
    public static void main(String[] args) {
        MediaPlayer player = new SpotifyPlayer();
        MediaLogger logger = new ConsoleMediaLogger();
        MediaService service = new MediaService(player, logger);
        service.playMedia();
        System.out.println("----------------");

        player = new VLCPlayer();
        service = new MediaService(player, logger);
        service.playMedia();
    }
}
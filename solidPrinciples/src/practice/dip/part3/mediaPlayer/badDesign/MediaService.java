package practice.dip.part3.mediaPlayer.badDesign;

public class MediaService {
    private final SpotifyPlayer player = new SpotifyPlayer();
    private final MediaLogger logger = new MediaLogger();

    public void playMedia() {
        player.play();
        logger.log("Media played");
    }
}
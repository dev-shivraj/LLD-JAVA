package practice.dip.part3.mediaPlayer.goodDesign;

public class MediaService {
    private final MediaPlayer player;
    private final MediaLogger logger;

    public MediaService(MediaPlayer player, MediaLogger logger) {
        this.player = player;
        this.logger = logger;
    }

    public void playMedia() {
        player.play();
        logger.log("Media played");
    }
}
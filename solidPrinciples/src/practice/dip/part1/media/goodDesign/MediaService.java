package practice.dip.part1.media.goodDesign;

public class MediaService {
    private final MediaPlayer player;

    public MediaService(MediaPlayer player) {
        this.player = player;
    }

    public void playMedia() {
        player.play();
    }
}
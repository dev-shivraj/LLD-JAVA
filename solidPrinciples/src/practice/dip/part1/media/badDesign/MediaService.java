package practice.dip.part1.media.badDesign;

public class MediaService {
    private final SpotifyPlayer player = new SpotifyPlayer();

    public void playMedia() {
        player.play();
    }
}
package practice.dip.part3.mediaPlayer.goodDesign;

public class SpotifyPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing using Spotify");
    }
}
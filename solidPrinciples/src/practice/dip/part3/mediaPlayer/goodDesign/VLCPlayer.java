package practice.dip.part3.mediaPlayer.goodDesign;

public class VLCPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing using VLC");
    }
}
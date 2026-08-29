package practice.dip.part1.media.goodDesign;

public class VLCPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing using VLC");
    }
}
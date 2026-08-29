package practice.isp.part1.mediaPlayer.badDesign;

public class BasicAudioPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing Audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing audio");
    }

    @Override
    public void record() {
        System.out.println("Basic Audio Player doesn't support recording");
    }

    @Override
    public void stream() {
        System.out.println("Basic Audio Player doesn't support streaming");
    }
}

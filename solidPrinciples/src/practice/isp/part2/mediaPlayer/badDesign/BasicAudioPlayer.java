package practice.isp.part2.mediaPlayer.badDesign;

public class BasicAudioPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping audio");
    }

    @Override
    public void record() {
        System.out.println("Recording not supported");
    }

    @Override
    public void stream() {
        System.out.println("Streaming not supported");
    }

    @Override
    public void download() {
        System.out.println("Downloading not supported");
    }
}
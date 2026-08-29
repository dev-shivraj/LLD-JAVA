package practice.isp.part2.mediaPlayer.goodDesign;

public class AdvancedMediaPlayer implements Playable, Recordable, Streamable, Downloadable {
    @Override
    public void play() {
        System.out.println("Playing media");
    }

    @Override
    public void pause() {
        System.out.println("Pausing media");
    }

    @Override
    public void stop() {
        System.out.println("Stopping media");
    }

    @Override
    public void record() {
        System.out.println("Recording media");
    }

    @Override
    public void stream() {
        System.out.println("Streaming media");
    }

    @Override
    public void download() {
        System.out.println("Downloading media");
    }
}
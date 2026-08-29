package practice.isp.part2.mediaPlayer.goodDesign;

public class BasicAudioPlayer implements Playable {
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
}
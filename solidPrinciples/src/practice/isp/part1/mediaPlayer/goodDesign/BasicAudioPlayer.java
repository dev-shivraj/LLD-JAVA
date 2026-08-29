package practice.isp.part1.mediaPlayer.goodDesign;


public class BasicAudioPlayer implements Playable, Pausable {
    @Override
    public void play() {
        System.out.println("Playing Audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing audio");
    }
}

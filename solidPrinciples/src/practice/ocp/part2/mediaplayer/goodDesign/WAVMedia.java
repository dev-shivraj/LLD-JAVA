package practice.ocp.part2.mediaplayer.goodDesign;

public class WAVMedia implements Playable {

    @Override
    public void play() {
        System.out.println("Playing WAV");
    }
}
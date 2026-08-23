package practice.ocp.part2.mediaplayer.goodDesign;

public class MP3Media implements Playable {

    @Override
    public void play() {
        System.out.println("Playing MP3");
    }
}
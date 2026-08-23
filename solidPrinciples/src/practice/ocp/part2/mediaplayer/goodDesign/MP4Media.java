package practice.ocp.part2.mediaplayer.goodDesign;

public class MP4Media implements Playable {

    @Override
    public void play() {
        System.out.println("Playing MP4");
    }
}
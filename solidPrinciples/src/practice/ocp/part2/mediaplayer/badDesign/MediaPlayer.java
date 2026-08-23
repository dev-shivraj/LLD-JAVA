package practice.ocp.part2.mediaplayer.badDesign;

public class MediaPlayer {

    public void play(String type) {
        if (type.equals("MP3")) {
            System.out.println("Playing MP3");
        } else if (type.equals("MP4")) {
            System.out.println("Playing MP4");
        } else if (type.equals("WAV")) {
            System.out.println("Playing WAV");
        }
    }
}
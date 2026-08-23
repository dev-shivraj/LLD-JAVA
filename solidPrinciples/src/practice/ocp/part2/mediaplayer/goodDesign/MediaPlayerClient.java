package practice.ocp.part2.mediaplayer.goodDesign;

import practice.ocp.part2.mediaplayer.goodDesign.newRequirement.FLACMedia;

public class MediaPlayerClient {

    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        player.play(new MP3Media());
        player.play(new MP4Media());
        player.play(new WAVMedia());

        // new requirement
        player.play(new FLACMedia());
    }
}
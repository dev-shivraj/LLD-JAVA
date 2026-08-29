package practice.isp.part2.mediaPlayer.badDesign;

public class MediaPlayerClient {
    public static void main(String[] args) {
        MediaPlayer player = new BasicAudioPlayer();
        player.play();
        player.pause();
        player.stop();

        player.record();
        player.stream();
        player.download();
    }
}
package practice.isp.part2.mediaPlayer.goodDesign;

public class MediaPlayerClient {
    public static void main(String[] args) {
        Playable player = new BasicAudioPlayer();
        player.play();
        player.pause();
        player.stop();
        System.out.println("----------------");

        Recordable recorder = new AdvancedMediaPlayer();
        recorder.record();
        System.out.println("----------------");

        Streamable streamer = new AdvancedMediaPlayer();
        streamer.stream();
        System.out.println("----------------");

        Downloadable downloader = new AdvancedMediaPlayer();
        downloader.download();
    }
}
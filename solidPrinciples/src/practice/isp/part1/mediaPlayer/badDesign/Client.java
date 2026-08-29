package practice.isp.part1.mediaPlayer.badDesign;

public class Client {
    public static void main(String[] args) {
        BasicAudioPlayer basicAudioPlayer = new BasicAudioPlayer();
        basicAudioPlayer.play();
        basicAudioPlayer.pause();
        basicAudioPlayer.record();
        basicAudioPlayer.stream();
    }
}

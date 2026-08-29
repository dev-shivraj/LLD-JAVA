package practice.isp.part1.mediaPlayer.goodDesign;


public class Client {
    public static void main(String[] args) {
        BasicAudioPlayer basicAudioPlayer = new BasicAudioPlayer();
        basicAudioPlayer.play();
        basicAudioPlayer.pause();
    }
}

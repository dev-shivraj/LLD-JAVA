package practice.lsp.part3.media.goodDesign;

public class MediaPlayerClient {
    public static void main(String[] args) {
        Playable mp3Player = new MP3Player();
        mp3Player.play();
        System.out.println("----------------");

        StreamingPlayer streamingPlayer = new StreamingPlayer();
        streamingPlayer.play();
        streamingPlayer.stream();
    }
}
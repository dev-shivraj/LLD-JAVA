package practice.lsp.part3.media.badDesign;

public class MediaPlayerClient {
    public static void main(String[] args) {
        MediaPlayer player = new MP3Player();
        player.play();
        player.stream();
    }
}
package practice.lsp.part1.media.badDesign;

public class MediaClient {
    public static void playMedia(MediaPlayer player) {
        player.play();
    }

    public static void main(String[] args) {
        MediaPlayer mp3 = new MP3Player();
        playMedia(mp3);

        MediaPlayer text = new TextMedia();
        playMedia(text);
    }
}
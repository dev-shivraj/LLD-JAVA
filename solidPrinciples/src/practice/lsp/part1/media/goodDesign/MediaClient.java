package practice.lsp.part1.media.goodDesign;

public class MediaClient {
    public static void playMedia(PlayableMedia media) {
        media.play();
    }

    public static void main(String[] args) {
        PlayableMedia mp3 = new MP3Media();
        playMedia(mp3);

        Media text = new TextMedia();
        System.out.println("Text media does not support play");
    }
}
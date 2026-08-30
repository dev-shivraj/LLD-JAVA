package practice.lsp.part2.postCondition.media.goodDesign;

public class MediaPlayerClient {
    public static void main(String[] args) {
        MediaPlayer player = new MP3Player();
        int duration = player.getDuration();
        System.out.println("Duration: " + duration);
    }
}
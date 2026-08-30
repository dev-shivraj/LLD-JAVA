package practice.lsp.part2.postCondition.media.badDesign;

public class MediaPlayerClient {
    public static void main(String[] args) {
        MediaPlayer player = new LiveStreamPlayer();
        int duration = player.getDuration();
        System.out.println("Duration: " + duration);
    }
}
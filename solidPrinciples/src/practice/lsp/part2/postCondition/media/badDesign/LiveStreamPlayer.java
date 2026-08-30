package practice.lsp.part2.postCondition.media.badDesign;

public class LiveStreamPlayer extends MediaPlayer {
    @Override
    public int getDuration() {
        return -1;
    }
}
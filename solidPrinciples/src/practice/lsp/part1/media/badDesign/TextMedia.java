package practice.lsp.part1.media.badDesign;

public class TextMedia extends MediaPlayer {
    @Override
    public void play() {
        throw new UnsupportedOperationException("Text cannot be played");
    }
}
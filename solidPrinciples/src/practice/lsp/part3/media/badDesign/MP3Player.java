package practice.lsp.part3.media.badDesign;

public class MP3Player extends MediaPlayer {
    @Override
    public void stream() {
        throw new UnsupportedOperationException("MP3 player cannot stream");
    }
}
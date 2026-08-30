package practice.lsp.part3.media.goodDesign;

public class StreamingPlayer implements Playable, Streamable {
    @Override
    public void play() {
        System.out.println("Playing streaming media");
    }

    @Override
    public void stream() {
        System.out.println("Streaming media");
    }
}
package practice.lsp.part3.media.goodDesign;

public class MP3Player implements Playable {
    @Override
    public void play() {
        System.out.println("Playing MP3");
    }
}
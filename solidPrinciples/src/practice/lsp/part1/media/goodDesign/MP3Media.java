package practice.lsp.part1.media.goodDesign;

public class MP3Media extends PlayableMedia {
    @Override
    public void play() {
        System.out.println("Playing MP3");
    }
}
package practice.dip.part3.mediaPlayer.goodDesign;

public class ConsoleMediaLogger implements MediaLogger {
    @Override
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
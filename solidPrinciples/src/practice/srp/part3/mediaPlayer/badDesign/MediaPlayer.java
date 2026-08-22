package practice.srp.part3.mediaPlayer.badDesign;

public class MediaPlayer {

    public void play() {
        System.out.println("Playing");
    }

    public void pause() {
        System.out.println("Paused");
    }

    public void stop() {
        System.out.println("Stopped");
    }

    public void loadFile() {
        System.out.println("Loading file");
    }

    public void savePlaybackHistory() {
        System.out.println("Saving playback history");
    }

    public void generatePlaylist() {
        System.out.println("Generating playlist");
    }

    public void sendNotification() {
        System.out.println("Sending notification");
    }
}
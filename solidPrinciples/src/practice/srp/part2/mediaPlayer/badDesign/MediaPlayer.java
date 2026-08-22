package practice.srp.part2.mediaPlayer.badDesign;

public class MediaPlayer {

    // group 1
    public void play() {
        System.out.println("Playing media");
    }

    // group 1
    public void pause() {
        System.out.println("Pausing media");
    }

    // group 1
    public void stop() {
        System.out.println("Stopping media");
    }

    // maybe group 1 but depends, load file includes file system, network call, db call etc then different group
    public void loadFile() {
        System.out.println("Loading media file");
    }

    // group 2 : persistence responsibility
    public void savePlaybackHistory() {
        System.out.println("Saving playback history");
    }

    // group 3 : kind of reporting/analytical responsibility
    public void generatePlaylist() {
        System.out.println("Generating playlist");
    }

    // group 4 : communication responsibility
    public void sendNotification() {
        System.out.println("Sending notification");
    }
}
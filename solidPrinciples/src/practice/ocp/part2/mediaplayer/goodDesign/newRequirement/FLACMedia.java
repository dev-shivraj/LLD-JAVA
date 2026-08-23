package practice.ocp.part2.mediaplayer.goodDesign.newRequirement;

import practice.ocp.part2.mediaplayer.goodDesign.Playable;

public class FLACMedia implements Playable {

    @Override
    public void play() {
        System.out.println("Playing FLAC");
    }
}
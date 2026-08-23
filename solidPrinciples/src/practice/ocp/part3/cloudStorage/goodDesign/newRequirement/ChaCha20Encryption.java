package practice.ocp.part3.cloudStorage.goodDesign.newRequirement;

import practice.ocp.part3.cloudStorage.goodDesign.Encryption;

public class ChaCha20Encryption implements Encryption {
    @Override
    public String encrypt(String file) {
        return "ChaCha20(" + file + ")";
    }
}
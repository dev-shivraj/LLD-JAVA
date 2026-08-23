package practice.ocp.part3.cloudStorage.goodDesign;

public class RsaEncryption implements Encryption {

    @Override
    public String encrypt(String file) {
        return "RSA(" + file + ")";
    }
}
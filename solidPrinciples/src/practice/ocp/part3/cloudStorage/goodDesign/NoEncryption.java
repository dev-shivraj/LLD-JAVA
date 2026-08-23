package practice.ocp.part3.cloudStorage.goodDesign;

public class NoEncryption implements Encryption {

    @Override
    public String encrypt(String file) {
        return file;
    }
}
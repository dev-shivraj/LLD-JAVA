package practice.ocp.part3.cloudStorage.goodDesign;

public class AesEncryption implements Encryption {

    @Override
    public String encrypt(String file) {
        return "AES(" + file + ")";
    }
}
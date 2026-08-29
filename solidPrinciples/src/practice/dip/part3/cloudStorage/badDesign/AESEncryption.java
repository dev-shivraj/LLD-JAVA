package practice.dip.part3.cloudStorage.badDesign;

public class AESEncryption {

    public String encrypt(String file) {
        System.out.println("Encrypting using AES");
        return "encrypted-" + file;
    }
}
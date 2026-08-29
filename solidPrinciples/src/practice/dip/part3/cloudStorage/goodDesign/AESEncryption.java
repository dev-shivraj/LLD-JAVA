package practice.dip.part3.cloudStorage.goodDesign;

public class AESEncryption implements Encryption {

    @Override
    public String encrypt(String file) {

        System.out.println(
                "Encrypting using AES"
        );

        return "encrypted-" + file;
    }
}
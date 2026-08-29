package practice.dip.part3.cloudStorage.goodDesign;

public class RSAEncryption implements Encryption {

    @Override
    public String encrypt(String file) {

        System.out.println(
                "Encrypting using RSA"
        );

        return "rsa-encrypted-" + file;
    }
}
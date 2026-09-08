package practice.factory.part3.example3.provider;

public class SmsProvider {

    public void sendSms(String message) {
        System.out.println("SMS Provider: Sending SMS -> " + message);
    }
}
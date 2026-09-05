package practice.adaptor.part1.notification.external;

public class SmsGateway {
    public void sendSms(String phoneNumber, String text) {
        System.out.println("SMS sent to " + phoneNumber + " : " + text);
    }
}

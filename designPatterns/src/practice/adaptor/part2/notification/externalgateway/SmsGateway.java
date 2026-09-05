package practice.adaptor.part2.notification.externalgateway;

public class SmsGateway {
    public void sendSms(String phoneNumber, String text) {
        System.out.println("SMS sent to " + phoneNumber + " : " + text);
    }
}

package practice.adapter.part2.externalgateway;

public class SmsGateway {
    public void sendSms(String phoneNumber, String text) {
        System.out.println("SMS sent to " + phoneNumber + " : " + text);
    }
}

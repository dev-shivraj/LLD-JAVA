package practice.ocp.part3.notification.goodDesign;

public class NotificationClient {

    public static void main(String[] args) {

        NotificationService emailService =
                new NotificationService(
                        new EmailSender(),
                        new HtmlFormatter()
                );

        emailService.send("Hello Shivraj");

        System.out.println("----------------");

        NotificationService smsService =
                new NotificationService(
                        new SmsSender(),
                        new PlainTextFormatter()
                );

        smsService.send("Payment successful");
    }
}
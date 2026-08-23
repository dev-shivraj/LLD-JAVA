package practice.ocp.part3.notification.goodDesign;

public class NotificationService {

    private final Sender sender;
    private final Formatter formatter;

    public NotificationService(Sender sender, Formatter formatter) {
        this.sender = sender;
        this.formatter = formatter;
    }

    public void send(String message) {
        String formattedMessage = formatter.format(message);
        sender.send(formattedMessage);
    }
}
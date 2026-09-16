package practice.flyweight.part5.practice2.intrinsic;

public class NotificationTemplate {

    private final String channel;
    private final String templateText;

    public NotificationTemplate(
            String channel,
            String templateText
    ) {
        this.channel = channel;
        this.templateText = templateText;
    }

    public void send(
            String recipient,
            String message
    ) {
        System.out.println(
                "Sending " + channel
                        + " notification to " + recipient
                        + ": " + message
        );
    }
}
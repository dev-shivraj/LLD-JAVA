package practice.flyweight.part5.practice2.extrinsic;

import practice.flyweight.part5.practice2.intrinsic.NotificationTemplate;

import java.util.Map;

public class Notification {

    private final String recipient;
    private final NotificationTemplate template;

    public Notification(
            String recipient,
            NotificationTemplate template
    ) {
        this.recipient = recipient;
        this.template = template;
    }

    public void send(Map<String, String> data) {

        String message =
                templateMessage(data);

        template.send(recipient, message);
    }

    private String templateMessage(
            Map<String, String> data
    ) {
        String message =
                "Hello " + data.get("name")
                        + ", your order "
                        + data.get("orderId")
                        + " is ready.";

        return message;
    }
}
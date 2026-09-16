package practice.flyweight.part5.practice2;

import practice.flyweight.part5.practice2.extrinsic.Notification;
import practice.flyweight.part5.practice2.factory.NotificationTemplateFactory;
import practice.flyweight.part5.practice2.intrinsic.NotificationTemplate;

import java.util.Map;

public class Client {

    public static void main(String[] args) {

        NotificationTemplateFactory factory = new NotificationTemplateFactory();

        String templateText = "Hello {name}, your order {orderId} is ready.";

        NotificationTemplate emailTemplate = factory.getTemplate("EMAIL", templateText);
        NotificationTemplate sameEmailTemplate = factory.getTemplate("EMAIL", templateText);

        Notification notification1 = new Notification("shiv@example.com", emailTemplate);
        Notification notification2 = new Notification("rahul@example.com", sameEmailTemplate);

        notification1.send(Map.of("name", "Shiv", "orderId", "ORD-101"));
        notification2.send(Map.of("name", "Rahul", "orderId", "ORD-102"));

        System.out.println("Same template: " + (emailTemplate == sameEmailTemplate));
        System.out.println("Unique templates: " + factory.getTemplateCount());
    }
}
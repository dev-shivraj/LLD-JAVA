package practice.decorator.part4.example1.decorator;

import practice.decorator.part4.example1.component.NotificationService;

public class MetricsDecorator extends NotificationDecorator {

    public MetricsDecorator(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void send(String message) {
        long startTime = System.currentTimeMillis();
        notificationService.send(message);
        long endTime = System.currentTimeMillis();

        System.out.println("[METRICS] Notification took " + (endTime - startTime) + " ms");
    }
}
package practice.factory.part2.factorymethod.factory;

import practice.factory.part2.factorymethod.component.Notification;

public abstract class NotificationFactory {
        public abstract Notification createNotification();

        public void sendNotification(String message) {
            Notification notification = createNotification();
            notification.send(message);
        }
}
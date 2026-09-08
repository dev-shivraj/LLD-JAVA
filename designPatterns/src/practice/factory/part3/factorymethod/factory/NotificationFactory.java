package practice.factory.part3.factorymethod.factory;

import practice.factory.part3.factorymethod.component.Notification;

public abstract class NotificationFactory {
        public abstract Notification createNotification();

        public void sendNotification(String message) {
            Notification notification = createNotification();
            notification.send(message);
        }
}
package practice.factory.part3.registryfactory.notification.factory;



import practice.factory.part3.registryfactory.notification.component.Notification;
import practice.factory.part3.registryfactory.notification.enums.NotificationType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {
    private final Map<NotificationType, Supplier<Notification>> creators = new HashMap<>();

    public void register(NotificationType notificationType, Supplier<Notification> creator) {
        creators.put(notificationType, creator);
    }

    public Notification create(NotificationType notificationType) {
        Supplier<Notification> creator = creators.get(notificationType);

        if(creator == null) {
            throw new IllegalArgumentException("Unsupported notification type: " + notificationType);
        }

        return creator.get();
    }
}

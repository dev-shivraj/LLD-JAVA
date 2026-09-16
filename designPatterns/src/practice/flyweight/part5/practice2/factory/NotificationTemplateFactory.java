package practice.flyweight.part5.practice2.factory;

import practice.flyweight.part5.practice2.intrinsic.NotificationTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationTemplateFactory {

    private final Map<NotificationTemplateKey, NotificationTemplate>
            templates = new ConcurrentHashMap<>();

    public NotificationTemplate getTemplate(
            String channel,
            String templateText
    ) {
        NotificationTemplateKey key =
                new NotificationTemplateKey(
                        channel,
                        templateText
                );

        return templates.computeIfAbsent(
                key,
                ignored -> new NotificationTemplate(
                        channel,
                        templateText
                )
        );
    }

    public int getTemplateCount() {
        return templates.size();
    }
}
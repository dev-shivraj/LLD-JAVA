package practice.flyweight.part5.practice2.factory;

import java.util.Objects;

public class NotificationTemplateKey {

    private final String channel;
    private final String templateText;

    public NotificationTemplateKey(
            String channel,
            String templateText
    ) {
        this.channel = channel;
        this.templateText = templateText;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NotificationTemplateKey other)) {
            return false;
        }

        return Objects.equals(channel, other.channel)
                && Objects.equals(templateText, other.templateText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channel, templateText);
    }
}
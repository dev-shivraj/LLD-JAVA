package practice.factory.part3.example3.sender;

import practice.factory.part3.example3.provider.WhatsAppProvider;

public class WhatsAppNotification implements NotificationSender {

    private final WhatsAppProvider provider;

    public WhatsAppNotification(WhatsAppProvider provider) {
        this.provider = provider;
    }

    @Override
    public void send(String message) {
        provider.sendWhatsApp(message);
    }
}
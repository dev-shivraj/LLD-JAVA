package practice.factory.part3.example3.sender;

import practice.factory.part3.example3.provider.EmailProvider;

public class EmailNotification implements NotificationSender {

    private final EmailProvider provider;

    public EmailNotification(EmailProvider provider) {
        this.provider = provider;
    }

    @Override
    public void send(String message) {
        provider.sendEmail(message);
    }
}
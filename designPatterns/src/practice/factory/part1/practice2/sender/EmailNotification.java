package practice.factory.part1.practice2.sender;

import practice.factory.part1.practice2.notificationclient.EmailClient;

public class EmailNotification implements NotificationSender {

    private final EmailClient emailClient;

    public EmailNotification(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void send(String message) {
        emailClient.sendEmail(message);
    }
}
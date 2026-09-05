package practice.factory.part3.registryfactory.notification.component;

class WhatsAppNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("WhatsApp: " + message);
    }
}
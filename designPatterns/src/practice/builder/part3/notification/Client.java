package practice.builder.part3.notification;

public class Client {
    public static void main(String[] args) {
        Notification notification = Notification.builder()
                        .setRecipient("Shivraj")
                        .setMessage("Payment successful")
                        .setTitle("Payment")
                        .setPriority("HIGH")
                        .setRetryCount(3)
                        // .setPushEnabled(true)
                        .build();

        System.out.println(notification.getRecipient());
        // System.out.println(notification.getEmail());
        System.out.println(notification.getMessage());
        System.out.println(notification.isPushEnabled());
    }
}

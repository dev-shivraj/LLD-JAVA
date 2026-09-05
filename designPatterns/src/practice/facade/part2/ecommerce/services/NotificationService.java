package practice.facade.part2.ecommerce.services;

public class NotificationService {
    public void sendConfirmation(String userId, String orderId) {
        System.out.println("Sending confirmation to user: " + userId + " for order: " + orderId);
    }
}
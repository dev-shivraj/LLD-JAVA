package practice.singleton.part3.doublechecked;

public class PaymentService {
    private static volatile PaymentService instance;

    private PaymentService() {
        System.out.println("Created by " + Thread.currentThread().getName());
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            synchronized (PaymentService.class) {
                if (instance == null) {
                    instance = new PaymentService();
                }
            }
        }

        return instance;
    }

    public void processPayment() {
        System.out.println("Payment processed by " + Thread.currentThread().getName() + " | instance=" + System.identityHashCode(this));
    }
}
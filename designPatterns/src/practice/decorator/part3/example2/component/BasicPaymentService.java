package practice.decorator.part3.example2.component;

public class BasicPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Processing payment: ₹" + amount);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
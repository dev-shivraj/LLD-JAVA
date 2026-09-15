package practice.decorator.part4.practice1.component;

public class BasicPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Processing payment: ₹" + amount);
    }
}
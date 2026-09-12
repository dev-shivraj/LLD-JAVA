package practice.decorator.part3.example1.component;

public class BasicPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Processing payment: ₹" + amount);
    }
}
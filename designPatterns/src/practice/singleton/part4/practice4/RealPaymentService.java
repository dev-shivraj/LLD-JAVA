package practice.singleton.part4.practice4;

public class RealPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Real payment processed");
    }
}
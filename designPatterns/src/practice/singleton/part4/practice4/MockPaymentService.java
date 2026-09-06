package practice.singleton.part4.practice4;

public class MockPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Mock payment processed");
    }
}
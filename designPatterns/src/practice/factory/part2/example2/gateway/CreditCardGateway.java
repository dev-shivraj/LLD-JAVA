package practice.factory.part2.example2.gateway;

public class CreditCardGateway implements PaymentGateway {
    @Override
    public void connect() {
        System.out.println("Connecting to Credit Card Gateway");
    }
}
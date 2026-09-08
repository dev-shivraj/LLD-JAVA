package practice.factory.part1.example3.gateway;

public class CreditCardGateway implements PaymentGateway {

    @Override
    public void process(double amount) {
        System.out.println("Credit Card Gateway processed: " + amount);
    }
}
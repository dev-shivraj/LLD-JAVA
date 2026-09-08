package practice.factory.part1.example3.gateway;

public class UpiGateway implements PaymentGateway {

    @Override
    public void process(double amount) {
        System.out.println("UPI Gateway processed: " + amount);
    }
}
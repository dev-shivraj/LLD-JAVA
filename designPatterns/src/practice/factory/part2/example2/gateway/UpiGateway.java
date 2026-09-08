package practice.factory.part2.example2.gateway;

public class UpiGateway implements PaymentGateway {
    @Override
    public void connect() {
        System.out.println("Connecting to UPI Gateway");
    }
}
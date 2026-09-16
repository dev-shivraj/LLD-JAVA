package practice.strategy.part3.practice3.strategy.shipping;

public class StandardShipping implements ShippingStrategy {

    @Override
    public double calculateShipping(double price) {
        return 100;
    }
}
package practice.strategy.part4.example1.strategy.delivery;

public class CarDelivery implements DeliveryStrategy {

    @Override
    public double calculateDeliveryFee(double distance) {
        return distance * 20;
    }
}
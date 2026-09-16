package practice.strategy.part4.example1.strategy.delivery;

public class BikeDelivery implements DeliveryStrategy {

    @Override
    public double calculateDeliveryFee(double distance) {
        return distance * 10;
    }
}
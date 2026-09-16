package practice.strategy.part4.example1.component;

public class Order {

    private final double foodAmount;
    private final double distance;

    public Order(double foodAmount, double distance) {
        this.foodAmount = foodAmount;
        this.distance = distance;
    }

    public double getFoodAmount() {
        return foodAmount;
    }

    public double getDistance() {
        return distance;
    }
}
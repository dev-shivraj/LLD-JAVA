package practice.strategy.part3.example2.strategy;

@FunctionalInterface
public interface DiscountStrategy {

    double calculateDiscount(double amount);
}
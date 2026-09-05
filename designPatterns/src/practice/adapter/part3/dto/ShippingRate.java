package practice.adapter.part3.dto;

public class ShippingRate {
    private final double amount;
    private final String provider;

    public ShippingRate(double amount, String provider) {
        this.amount = amount;
        this.provider = provider;
    }

    public double getAmount() {
        return amount;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return provider + " shipping rate: ₹" + amount;
    }
}
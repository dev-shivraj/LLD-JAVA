package practice.decorator.part5.practice1.component;

public class BasicShippingService implements ShippingService {

    @Override
    public void ship(String orderId) {
        System.out.println("Shipping order: " + orderId);
    }
}
package practice.dip.part4.integrated.goodDesign;

public class MongoOrderRepository implements OrderRepository {
    @Override
    public void save(String orderId) {
        System.out.println("Order " + orderId + " saved to MongoDB");
    }
}
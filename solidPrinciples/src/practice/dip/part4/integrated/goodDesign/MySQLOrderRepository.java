package practice.dip.part4.integrated.goodDesign;

public class MySQLOrderRepository implements OrderRepository {
    @Override
    public void save(String orderId) {
        System.out.println("Order " + orderId + " saved to MySQL");
    }
}
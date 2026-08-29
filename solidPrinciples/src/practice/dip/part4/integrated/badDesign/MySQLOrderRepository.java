package practice.dip.part4.integrated.badDesign;

public class MySQLOrderRepository {
    public void save(String orderId) {
        System.out.println("Order " + orderId + " saved to MySQL");
    }
}
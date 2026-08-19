package inventory_management_system.orders;

public class Client {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        // Adding orders
        orderProcessor.addOrder(new Order("Order1", false)); // Regular
        orderProcessor.addOrder(new Order("Order2", true));  // Express
        orderProcessor.addOrder(new Order("Order3", false)); // Regular
        orderProcessor.addOrder(new Order("Order4", true));  // Express

        // Processing orders
        System.out.println("Processing Orders:");
        Order processedOrder;
        while ((processedOrder = orderProcessor.processOrder()) != null) {
            System.out.println(processedOrder);
        }
    }
}

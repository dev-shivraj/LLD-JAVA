package practice.facade.part1.withfacade;

public class OrderFacade {

    /*

        private final InventoryService inventoryService;
        private final PaymentService paymentService;
        private final ShippingService shippingService;
        private final NotificationService notificationService;

        public OrderFacade(InventoryService inventoryService, PaymentService paymentService, ShippingService shippingService, NotificationService notificationService) {
            this.inventoryService = inventoryService;
            this.paymentService = paymentService;
            this.shippingService = shippingService;
            this.notificationService = notificationService;
        }

        public void placeOrder(Order order) {
            inventoryService.reserve(order);
            paymentService.processPayment(order);
            shippingService.createShipment(order);
            notificationService.sendConfirmation(order);
        }

     */


    // now the client only needs :
    /*
        OrderFacade facade = ...;
        facade.placeOrder(order);
     */
}
package practice.facade.base.facade;

import practice.facade.base.InventoryService;
import practice.facade.base.InvoiceService;
import practice.facade.base.MailService;
import practice.facade.base.Order;

public class PlaceOrderFacade {
    private MailService mailService;
    private InvoiceService invoiceService;
    private InventoryService inventoryService;

    public PlaceOrderFacade() {
        this.inventoryService = new InventoryService();
        this.mailService = new MailService();
        this.invoiceService = new InvoiceService();
    }


    public void placeOrder(Order order) {
        try {
            inventoryService.updateInventory(order);
            mailService.sendEmail(order);
            invoiceService.generateInvoice(order);
        } catch (Exception e) {
            System.out.println("SOmething has gone wrong. ");
        }
    }
}
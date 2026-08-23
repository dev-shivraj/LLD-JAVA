package practice.ocp.part2.payment.goodDesign;

import practice.ocp.part2.payment.goodDesign.newRequirement.ApplePayPayment;

public class PaymentClient {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        service.processPayment(new UPIPayment(), 1000);
        service.processPayment(new CreditCardPayment(), 2000);
        service.processPayment(new PaypalPayment(), 3000);

        // new Requirement
        service.processPayment(new ApplePayPayment(), 5000);
    }
}
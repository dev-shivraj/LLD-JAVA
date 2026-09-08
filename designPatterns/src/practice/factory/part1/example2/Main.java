package practice.factory.part1.example2;

import practice.factory.part1.example2.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("upi", 1000);
        paymentService.processPayment("credit_card", 2500);
        paymentService.processPayment("paypal", 500);
    }
}
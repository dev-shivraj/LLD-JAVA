package practice.factory.part2.practice1;

import practice.factory.part2.practice1.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.process("upi", 500);
        service.process("credit_card", 1000);
        service.process("paypal", 1500);
    }
}
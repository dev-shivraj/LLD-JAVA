package practice.factory.part2.example2;

import practice.factory.part2.example2.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.process("upi", 500);
        service.process("credit_card", 1000);
    }
}
package practice.factory.part1.example3;

import practice.factory.part1.example3.service.PaymentService;

public class Main {

    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.process("upi", 1000);
        service.process("credit_card", 2500);
    }
}
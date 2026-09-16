package practice.strategy.part4.practice1;

import practice.strategy.part4.practice1.service.PaymentService;
import practice.strategy.part4.practice1.strategy.CardPayment;
import practice.strategy.part4.practice1.strategy.UpiPayment;
import practice.strategy.part4.practice1.strategy.WalletPayment;

public class Main {

    public static void main(String[] args) {

        PaymentService upiPayment = new PaymentService(new UpiPayment());
        PaymentService cardPayment = new PaymentService(new CardPayment());
        PaymentService walletPayment = new PaymentService(new WalletPayment());

        upiPayment.processPayment(1000);
        cardPayment.processPayment(2000);
        walletPayment.processPayment(500);
    }
}
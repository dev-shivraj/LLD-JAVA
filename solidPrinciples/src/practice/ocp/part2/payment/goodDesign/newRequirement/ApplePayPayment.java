package practice.ocp.part2.payment.goodDesign.newRequirement;

import practice.ocp.part2.payment.goodDesign.Payment;

public class ApplePayPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Apple Pay payment: " + amount);
    }
}
package practice.ocp.part4.payment.goodDesign.newRequirement;

import practice.ocp.part4.payment.goodDesign.Payment;

public class ApplePayPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing Apple Pay: " + amount);
    }
}
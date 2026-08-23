package practice.ocp.part1.payment.goodDesign.newRequirement;

import practice.ocp.part1.payment.goodDesign.Payment;

public class NetBankingPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing NetBanking payment");
    }
}

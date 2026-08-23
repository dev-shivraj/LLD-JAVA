package practice.ocp.part1.payment.goodDesign;

import practice.ocp.part1.payment.goodDesign.newRequirement.NetBankingPayment;

public class PaymentClient {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        Payment upiPayment = new UpiPayment();
        Payment paypalPayment = new PaypalPayment();

        // new requirement
        Payment netBankingPayment = new NetBankingPayment();




        creditCardPayment.process();
        upiPayment.process();
        paypalPayment.process();

        // new requirement
        netBankingPayment.process();
    }
}

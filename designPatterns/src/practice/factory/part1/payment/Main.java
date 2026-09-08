package practice.factory.part1.payment;

import practice.factory.part1.payment.enums.PaymentType;

public class Main {

    public static void main(String[] args) {

        PaymentMethodFactory factory =
                new PaymentMethodFactory();

        PaymentService paymentService =
                new PaymentService(factory);

        PaymentRequest request =
                new PaymentRequest(
                        PaymentType.UPI,
                        1000
                );

        PaymentResult result =
                paymentService.process(request);

        System.out.println("Success: " + result.success());
        System.out.println("Transaction ID: " + result.transactionId());
        System.out.println("Message: " + result.message());
    }
}
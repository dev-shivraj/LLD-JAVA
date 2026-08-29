package practice.dip.part3.payment.goodDesign;

public class PaymentClient {

    public static void main(String[] args) {

        PaymentGateway paymentGateway =
                new StripePayment();

        TaxCalculator taxCalculator =
                new IndiaTaxCalculator();

        Notification notification =
                new EmailNotification();

        PaymentService service =
                new PaymentService(
                        paymentGateway,
                        taxCalculator,
                        notification
                );

        service.processPayment(1000);

        System.out.println("----------------");

        paymentGateway =
                new RazorpayPayment();

        service =
                new PaymentService(
                        paymentGateway,
                        taxCalculator,
                        notification
                );

        service.processPayment(2000);
    }
}
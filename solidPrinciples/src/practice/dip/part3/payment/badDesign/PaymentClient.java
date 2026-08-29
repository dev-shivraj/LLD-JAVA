package practice.dip.part3.payment.badDesign;

public class PaymentClient {

    public static void main(String[] args) {

        PaymentService service =
                new PaymentService();

        service.processPayment(1000);
    }
}
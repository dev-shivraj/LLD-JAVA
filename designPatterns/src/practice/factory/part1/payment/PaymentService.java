package practice.factory.part1.payment;

public class PaymentService {

    private final PaymentMethodFactory paymentMethodFactory;

    public PaymentService(PaymentMethodFactory paymentMethodFactory) {
        this.paymentMethodFactory = paymentMethodFactory;
    }

    public PaymentResult process(PaymentRequest request) {
        PaymentMethod paymentMethod =
                paymentMethodFactory.create(request.paymentType());

        return paymentMethod.pay(request);
    }
}
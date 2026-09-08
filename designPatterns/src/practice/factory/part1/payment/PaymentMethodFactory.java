package practice.factory.part1.payment;

import practice.factory.part1.payment.enums.PaymentType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentMethodFactory {

    private final Map<PaymentType, Supplier<PaymentMethod>> registry =
            new EnumMap<>(PaymentType.class);

    public PaymentMethodFactory() {
        register(PaymentType.UPI, UpiPaymentMethod::new);
        register(PaymentType.CREDIT_CARD, CreditCardPaymentMethod::new);
        register(PaymentType.PAYPAL, PayPalPaymentMethod::new);
    }

    public void register(
            PaymentType type,
            Supplier<PaymentMethod> creator
    ) {
        registry.put(type, creator);
    }

    public PaymentMethod create(PaymentType type) {
        Supplier<PaymentMethod> creator = registry.get(type);

        if (creator == null) {
            throw new IllegalArgumentException(
                    "Unsupported payment type: " + type
            );
        }

        return creator.get();
    }
}
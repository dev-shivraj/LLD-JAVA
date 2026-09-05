package practice.factory.part3.registryfactory.factory;

import practice.factory.part3.registryfactory.PaymentType;
import practice.factory.part3.registryfactory.component.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {
    private final Map<PaymentType, Supplier<Payment>> creators = new HashMap<>();

    public void register(PaymentType type, Supplier<Payment> creator) {
        creators.put(type, creator);
    }

    public Payment create(PaymentType type) {
        Supplier<Payment> creator = creators.get(type);

        if(creator == null ) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return creator.get();
    }
}

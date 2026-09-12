package practice.decorator.part3.example3.decorator;

import practice.decorator.part3.example3.component.PaymentService;

public class RetryDecorator extends PaymentServiceDecorator {

    private final int maxAttempts;

    public RetryDecorator(PaymentService paymentService, int maxAttempts) {
        super(paymentService);
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void pay(double amount) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                paymentService.pay(amount);
                return;
            } catch (RuntimeException exception) {
                System.out.println("[RETRY] Attempt " + attempt + " failed");

                if (attempt == maxAttempts) {
                    throw exception;
                }
            }
        }
    }
}
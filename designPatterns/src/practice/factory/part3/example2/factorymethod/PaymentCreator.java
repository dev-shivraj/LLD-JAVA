package practice.factory.part3.example2.factorymethod;

import practice.factory.part3.example2.processor.PaymentProcessor;

public abstract class PaymentCreator {

    protected abstract PaymentProcessor createPayment();

    public void processPayment(double amount) {
        validate(amount);

        PaymentProcessor processor = createPayment();

        startTransaction();
        processor.pay(amount);
        recordTransaction(amount);
        completeTransaction();
    }

    private void validate(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        System.out.println("Payment validated");
    }

    private void startTransaction() {
        System.out.println("Transaction started");
    }

    private void recordTransaction(double amount) {
        System.out.println("Transaction recorded: " + amount);
    }

    private void completeTransaction() {
        System.out.println("Transaction completed");
    }
}
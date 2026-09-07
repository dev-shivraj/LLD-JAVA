package practice.registry.part4.practice2;

import practice.registry.part4.practice2.processor.PaymentProcessor;
import practice.registry.part4.practice2.processor.UPIPayment;
import practice.registry.part4.practice2.registry.ThreadSafeRegistry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeRegistry<PaymentProcessor> registry = new ThreadSafeRegistry<>();
        registry.register("upi", UPIPayment::new);


        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;

            executor.submit(() -> {
                Supplier<PaymentProcessor> creator = registry.get("upi");
                PaymentProcessor processor = creator.get();
                System.out.println("Thread " + threadNumber + " created " + processor.getClass().getSimpleName());
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All threads completed.");
    }
}
package practice.registry.part4.example3;

import practice.registry.part4.example3.processor.PaymentProcessor;
import practice.registry.part4.example3.processor.UPIPayment;
import practice.registry.part4.example3.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Registry<PaymentProcessor> registry = new Registry<>();
        registry.register("upi", UPIPayment::new);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;

            tasks.add(() -> {
                Supplier<PaymentProcessor> creator = registry.get("upi");
                PaymentProcessor processor = creator.get();
                System.out.println("Thread " + threadNumber + " created " + processor.getClass().getSimpleName());
            });
        }

        for (Runnable task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("All threads completed.");
    }
}
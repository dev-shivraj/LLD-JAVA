package practice.singleton.part3.doublechecked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                PaymentService service = PaymentService.getInstance();
                service.processPayment();
            });
        }

        executor.shutdown();
    }
}
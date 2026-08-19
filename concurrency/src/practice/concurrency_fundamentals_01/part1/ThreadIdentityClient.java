package practice.concurrency_fundamentals_01.part1;

public class ThreadIdentityClient {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " having id : " + Thread.currentThread().getId());
        }, "worker-1");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " having id : " + Thread.currentThread().getId());
        }, "worker-2");

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " having id : " + Thread.currentThread().getId());
        }, "worker-3");

        Thread thread4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " having id : " + Thread.currentThread().getId());
        }, "worker-4");

        Thread thread5 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " having id : " + Thread.currentThread().getId());
        }, "worker-5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

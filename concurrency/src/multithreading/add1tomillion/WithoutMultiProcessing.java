package multithreading.add1tomillion;

public class WithoutMultiProcessing {
    static void main() {
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Sum: " + sum);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}

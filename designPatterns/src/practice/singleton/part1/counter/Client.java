package practice.singleton.part1.counter;

public class Client {
    public static void main(String[] args) {
        Counter counter1 = Counter.getInstance();
        Counter counter2 = Counter.getInstance();

        counter1.increment();
        counter1.increment();

        System.out.println(counter2.getCount());

        System.out.println(counter1 == counter2);
    }
}
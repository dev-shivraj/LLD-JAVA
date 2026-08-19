package practice.boundedgenerics_04.part2;

public class Client {
    public static void main(String[] args) {
        // =====================================

        double value = NumberUtility.convert(10);
        double value2 = NumberUtility.convert(20.5);
        double value3 = NumberUtility.convert(100L);

        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);


        // =====================================
    }
}

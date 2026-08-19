package practice.boundedgenerics_04.part6;

public class Client {
    public static void main(String[] args) {
        Integer result = MaximumUtility.max(10, 20);
        String result2 = MaximumUtility.max("Java", "Python");
        Double result3 = MaximumUtility.max(10.5, 20.5);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}

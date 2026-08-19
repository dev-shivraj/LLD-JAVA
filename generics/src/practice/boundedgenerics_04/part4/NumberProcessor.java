package practice.boundedgenerics_04.part4;

public class NumberProcessor<T extends Number & Comparable<T>> {
    public void process(T value1, T value2) {
        System.out.println("double value of value 1 : " + value1.doubleValue());

        int compareResult = value1.compareTo(value2);
        System.out.println(compareResult);
    }
}

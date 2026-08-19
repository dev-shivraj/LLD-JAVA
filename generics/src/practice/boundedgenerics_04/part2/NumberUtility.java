package practice.boundedgenerics_04.part2;

public class NumberUtility {
    public static <T extends Number> double convert(T value) {
        return value.doubleValue();
    }
}

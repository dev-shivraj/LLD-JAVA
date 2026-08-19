package practice.boundedgenerics_04.part6;

class MaximumUtility {

    public static <T extends Comparable<T>> T max(T first, T second) {

        if (first.compareTo(second) > 0) {
            return first;
        }

        return second;
    }
}
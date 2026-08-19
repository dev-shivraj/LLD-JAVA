package practice.boundedgenerics_04.part1;

public class Client {
    public static void main(String[] args) {
        // ===========================================================================
//        NumberBox<Integer> integerNumberBox = new NumberBox<>();
//        integerNumberBox.setValue(10);
//        int intValue = integerNumberBox.getIntValue();
//        double doubleValue = integerNumberBox.getDoubleValue();
//
//        System.out.println(intValue);
//        System.out.println(doubleValue);


        // ===========================================================================

//        NumberBox<Long> longNumberBox = new NumberBox<>();
//        longNumberBox.setValue(10L);
//        int intValue = longNumberBox.getIntValue();
//        double doubleValue = longNumberBox.getDoubleValue();
//
//        System.out.println(intValue);
//        System.out.println(doubleValue);

        // ===========================================================================

        NumberBox<Double> doubleNumberBox = new NumberBox<>();
        doubleNumberBox.setValue(10.0);
        int intValue = doubleNumberBox.getIntValue();
        double doubleValue = doubleNumberBox.getDoubleValue();

        System.out.println(intValue);
        System.out.println(doubleValue);

        // ===========================================================================
    }
}

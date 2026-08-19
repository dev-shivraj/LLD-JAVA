package practice.boundedgenerics_04.part4;

public class Client {
    public static void main(String[] args) {
        // ====================================

//        NumberProcessor<Integer> numberProcessor = new NumberProcessor<>();
//        numberProcessor.process(10, 20);
//        numberProcessor.process(10, 10);
//        numberProcessor.process(20, 10);

        // ====================================

//        NumberProcessor<Double> doubleNumberProcessor = new NumberProcessor<>();
//        doubleNumberProcessor.process(10.0, 20.0);
//        doubleNumberProcessor.process(10.0, 10.0);
//        doubleNumberProcessor.process(20.0, 10.0);

        // ====================================

        NumberProcessor<Long> longNumberProcessor = new NumberProcessor<>();
        longNumberProcessor.process(10L, 20L);
        longNumberProcessor.process(10L, 10L);
        longNumberProcessor.process(20L, 10L);

        // it won't work
        // NumberProcessor<String> stringNumberProcessor= new NumberProcessor<>();

        // ====================================

        // ====================================
    }
}

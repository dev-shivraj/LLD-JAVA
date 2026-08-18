package practice.genericinterface.part2;

public class Client {
    public static void main(String[] args) {
        // ===========================================

        GenericStorage<String> stringGenericStorage = new GenericStorage<>();
        stringGenericStorage.save("Shivraj");
        System.out.println(stringGenericStorage.get());


        System.out.println("-------------------");
        Storage<String> stringGenericStorage2 = new GenericStorage<>();
        stringGenericStorage2.save("Shivraj");
        System.out.println(stringGenericStorage2.get());
        // ===========================================

        System.out.println("-------------------");
        GenericStorage<Integer> integerStorage = new GenericStorage<>();
        integerStorage.save(100);
        System.out.println(integerStorage.get());



        System.out.println("-------------------");
        Storage<Integer> integerStorage2 = new GenericStorage<>();
        integerStorage2.save(100);
        System.out.println(integerStorage2.get());
        // ===========================================

        System.out.println("-------------------");
        GenericStorage<Double> doubleStorage = new GenericStorage<>();
        doubleStorage.save(100.50);
        System.out.println(doubleStorage.get());

        System.out.println("-------------------");
        Storage<Double> doubleStorage2 = new GenericStorage<>();
        doubleStorage2.save(100.50);
        System.out.println(doubleStorage2.get());

        // ===========================================

        // ===========================================
    }
}

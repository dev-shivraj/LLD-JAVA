package practice.genericinterface.part1;

public class Client {
    public static void main(String[] args) {
        // ===========================================

        StringStorage storage1 = new StringStorage();
        storage1.save("Shivraj");
        String getName = storage1.get();
        System.out.println(getName);

        System.out.println("-------------------");

        Storage<String> storage2 = new StringStorage();
        storage2.save("Singh");
        String getName2 = storage2.get();
        System.out.println(getName2);

        // ===========================================

        System.out.println("------------------------");
        IntegerStorage integerStorage = new IntegerStorage();
        integerStorage.save(100);
        System.out.println(integerStorage.get());


        System.out.println("------------------------");
        Storage<Integer> integerStorage2 = new IntegerStorage();
        integerStorage2.save(100);
        System.out.println(integerStorage2.get());
        // ===========================================

    }
}

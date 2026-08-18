package practice.genericclass;

public class Client {
    public static void main(String[] args) {

        // ============================================================

        Pair<Integer, String> pair = new Pair<>(101, "Shivraj");
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        // ============================================================

        Container<String> stringContainer = new Container<>("Hello");
        System.out.println(stringContainer.getValue());
        stringContainer.setValue("Java");



        Container<Integer> integerContainer = new Container<>(100);
        System.out.println(integerContainer.getValue());
        integerContainer.setValue(200);

        // ============================================================


//        Container<String> stringContainer = new Container<>("Hello");
//        stringContainer.setValue(100); // ❌


        // ============================================================
    }
}

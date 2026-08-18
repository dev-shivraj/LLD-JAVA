package practice.genericmethod;

public class Client {
    public static void main(String[] args) {

        // ============================================================

        Utility.print("Shivraj Kumar");

        // ============================================================

        String name = Utility.identity("Shivraj");
        Double salary = Utility.identity(150_000.00);
        int age = Utility.identity(22);

        System.out.println(name);
        System.out.println(salary);
        System.out.println(age);

        System.out.println("----------------");

        // ============================================================

        Box<String> box = new Box<>();
        box.setValue("Shivraj");
        box.print(100);

        box.print(box.getValue());

        // ============================================================
    }
}

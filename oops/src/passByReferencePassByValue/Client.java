package passByReferencePassByValue;

public class
Client {
    public static void main(String[] args) {

        int x = 10;

        // it will not change the value of x because it is passed by value
        // so add method will create a copy of x and change the value of that copy, but not the original x
        // so the value of x will remain 10 after the method call
        add(x);
        System.out.println(x);
    }

    public static void add(int x) {
        x = x + 10;
    }
}

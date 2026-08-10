package generics.implementation_with_generics;

public class Client {
    static void main() {
        Pair<String, Double> p = new Pair<>("Hello", 2.0);


        // this will cause compile time error
        // as we are trying to use primitive types instead of wrapper classes
        // there is nothing called as generic primitive
        // the topic name is always generic Class
        // Pair<String, double> p1 = new Pair<>();

        p.setX("Hello");
        p.setY(20.0);

        // this will cause compile time error
        // as we are trying to set a int value to a Pair that is supposed to hold a String and Double
        // p.setX(10); // Compile time error
        // p.setY(10); // Compile time error => setting int value to a Double type

        String x = p.getX();
        Double y = p.getY();

        System.out.println(x);
        System.out.println(y);
        System.out.println("********************************");


        // =========    use static method of generic class   ==========================
        System.out.println("********************************");
        Pair.print("Hello");
        Pair.print(100);
        Pair.print(10.5);
        Pair.print(true);
        System.out.println("=======");
        // we can also use the static method of generic class with explicit type parameter
        Pair.<String>print("Hello");
        Pair.<Integer>print(100);
        Pair.<Double>print(10.5);
        System.out.println("********************************");


        System.out.println("********************************");

        String s = Pair.getValue("Hello");
        Integer i = Pair.getValue(100);
        Double d = Pair.getValue(10.5);

        System.out.println(s);
        System.out.println(i);
        System.out.println(d);

        System.out.println("********************************");


        System.out.println("********************************");

        String s1 = Pair.<String>getAnotherValue();
        Integer i1 = Pair.<Integer>getAnotherValue();
        Double d1 = Pair.<Double>getAnotherValue();

        System.out.println("********************************");
        // =========    use static method of generic class   ==========================
    }
}

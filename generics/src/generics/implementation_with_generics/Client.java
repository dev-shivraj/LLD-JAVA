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
    }
}

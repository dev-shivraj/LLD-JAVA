package generics.problem_without_generics;

public class ObjectClient {
    static void main() {
//        generics.implementation_with_generics.Pair p = new generics.implementation_with_generics.Pair(1, 2);

        ObjectPair p = new ObjectPair(); // x, y
        p.setX(10);
        p.setY(20);

        // this will cause problem as we are trying to set a String value to a Pair that is supposed to hold integers
        // at compile time, this will not cause any error as we are using raw types
        // but at runtime, it will throw a ClassCastException
        p.setX("Hello");

        int x = (int) p.getX();
        int y = (int) p.getY();

        System.out.println(x);
        System.out.println(y);
    }
}

package generics;

public class Client {
    static void main() {
//        generics.Pair p = new generics.Pair(1, 2);

        Pair p = new Pair(); // x, y
        p.setX(10);
        p.setY(20);

        int x = (int) p.getX();
        int y = (int) p.getY();

        System.out.println(x);
        System.out.println(y);
    }
}

package generics.implementation_with_generics;

public class Pair<T, V> {
    T x;
    V y;

    //  ====================    static variations of generics       ==========================
    public static <T> void print(T value) {
        System.out.println(value);
    }

    public static <T> T getValue(T value) {
        return value;
    }

    public static <T> T getAnotherValue() {
        return null;
    }

    //  ======================================================================================
    public Pair() {}

    public Pair(T x, V y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public V getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(V y) {
        this.y = y;
    }

}

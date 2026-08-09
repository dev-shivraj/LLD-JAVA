package generics.implementation_with_generics;

public class Pair<T, V> {
    T x;
    V y;

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

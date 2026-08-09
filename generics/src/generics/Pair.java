package generics;

public class Pair {
    Object x;
    Object y;

    public Pair() {}


    public Pair(Object x, Object y) {
        this.x = x;
        this.y = y;
    }

    public Object getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public void setY(Object y) {
        this.y = y;
    }
}

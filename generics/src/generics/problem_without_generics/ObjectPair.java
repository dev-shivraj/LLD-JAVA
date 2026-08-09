package generics.problem_without_generics;

public class ObjectPair {
    Object x;
    Object y;

    public ObjectPair() {}


    public ObjectPair(Object x, Object y) {
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

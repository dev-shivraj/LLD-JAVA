package practice.genericmethod_02;

public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public <U> void print(U value) {
        System.out.println(value);
    }
}

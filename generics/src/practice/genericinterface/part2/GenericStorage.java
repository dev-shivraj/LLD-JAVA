package practice.genericinterface.part2;

public class GenericStorage<T> implements Storage<T>{
    private T value;

    public void save(T value) {
        this.value = value;
        System.out.println("saved: " + value);
    }

    public T get() {
        return this.value;
    }
}

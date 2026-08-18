package practice.genericinterface.part1;

public interface Storage<T> {
    void save(T value);
    T get();
}

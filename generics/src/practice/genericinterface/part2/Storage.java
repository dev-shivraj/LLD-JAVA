package practice.genericinterface.part2;

public interface Storage<T> {
    void save(T value);
    T get();
}

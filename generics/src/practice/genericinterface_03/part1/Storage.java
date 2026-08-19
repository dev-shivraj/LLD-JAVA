package practice.genericinterface_03.part1;

public interface Storage<T> {
    void save(T value);
    T get();
}

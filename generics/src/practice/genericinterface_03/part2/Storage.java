package practice.genericinterface_03.part2;

public interface Storage<T> {
    void save(T value);
    T get();
}

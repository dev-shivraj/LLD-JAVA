package practice.genericclass;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(){
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    static <T> void initialize(T value) {
        System.out.println("Class pair is initialized with value : " + value);
    }
}

package practice.singleton.part4.practice3;

public class CloneSafeSingleton implements Cloneable {
    private static final CloneSafeSingleton INSTANCE = new CloneSafeSingleton();

    private CloneSafeSingleton() {
    }

    public static CloneSafeSingleton getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }
}
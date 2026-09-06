package practice.singleton.part2.enumsingleton;

public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something");
    }
}
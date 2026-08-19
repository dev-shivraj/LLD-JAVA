package practice.genericinterface_03.part1;

public class StringStorage implements Storage<String> {
    private String value;

    public void save(String value) {
        this.value = value;
        System.out.println("saved : " + value);
    }

    public String get() {
        return this.value;
    }
}

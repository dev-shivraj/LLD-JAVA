package practice.genericinterface.part1;

public class IntegerStorage implements Storage<Integer> {
    private Integer value;

    public void save(Integer value) {
        this.value = value;
        System.out.println("saved : " + value);
    }

    public Integer get() {
        return this.value;
    }
}

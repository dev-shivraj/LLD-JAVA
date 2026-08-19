package practice.boundedgenerics_04.part1;

public class NumberBox<T extends Number> {
    private T value;

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Double getDoubleValue() {
        return this.value.doubleValue();
    }

    public Integer getIntValue() {
        return this.value.intValue();
    }

}

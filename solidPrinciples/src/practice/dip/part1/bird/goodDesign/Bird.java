package practice.dip.part1.bird.goodDesign;

public class Bird {
    private final String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
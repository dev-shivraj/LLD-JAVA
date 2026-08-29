package practice.dip.part3.bird.badDesign;

public class Bird {
    private final String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

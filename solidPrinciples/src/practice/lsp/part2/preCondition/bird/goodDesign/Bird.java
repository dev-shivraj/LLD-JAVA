package practice.lsp.part2.preCondition.bird.goodDesign;

public class Bird {
    public void fly(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }

        System.out.println("Bird is flying at " + height + " meters");
    }
}
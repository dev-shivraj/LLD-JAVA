package practice.lsp.part2.preCondition.bird.goodDesign;

public class Sparrow extends Bird {
    @Override
    public void fly(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }

        System.out.println("Sparrow is flying at " + height + " meters");
    }
}
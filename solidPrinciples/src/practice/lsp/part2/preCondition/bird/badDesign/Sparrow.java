package practice.lsp.part2.preCondition.bird.badDesign;

public class Sparrow extends Bird {
    @Override
    public void fly(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("Sparrow must fly at least 100 meters");
        }

        System.out.println("Sparrow is flying at " + height + " meters");
    }
}
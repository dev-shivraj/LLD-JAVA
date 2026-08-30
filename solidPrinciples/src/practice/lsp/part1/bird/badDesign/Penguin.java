package practice.lsp.part1.bird.badDesign;

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin cannot fly");
    }
}
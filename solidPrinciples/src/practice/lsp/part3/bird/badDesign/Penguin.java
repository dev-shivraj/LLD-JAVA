package practice.lsp.part3.bird.badDesign;

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin cannot fly");
    }
}
package practice.strategy.part1.practice2.strategy;

public class ZipCompressionStrategy implements CompressionStrategy {

    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using ZIP");
    }
}
package practice.strategy.part1.practice2.strategy;

public class GzipCompressionStrategy implements CompressionStrategy {

    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using GZIP");
    }
}
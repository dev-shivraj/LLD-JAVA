package practice.strategy.part1.practice2.service;

import practice.strategy.part1.practice2.strategy.CompressionStrategy;

public class FileCompressor {

    private final CompressionStrategy compressionStrategy;

    public FileCompressor(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void compress(String fileName) {
        compressionStrategy.compress(fileName);
    }
}
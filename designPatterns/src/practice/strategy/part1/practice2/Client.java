package practice.strategy.part1.practice2;

import practice.strategy.part1.practice2.service.FileCompressor;
import practice.strategy.part1.practice2.strategy.GzipCompressionStrategy;
import practice.strategy.part1.practice2.strategy.RarCompressionStrategy;
import practice.strategy.part1.practice2.strategy.ZipCompressionStrategy;

public class Client {

    public static void main(String[] args) {

        FileCompressor zipCompressor = new FileCompressor(new ZipCompressionStrategy());
        zipCompressor.compress("report.pdf");


        FileCompressor gzipCompressor = new FileCompressor(new GzipCompressionStrategy());
        gzipCompressor.compress("data.txt");


        FileCompressor rarCompressor = new FileCompressor(new RarCompressionStrategy());
        rarCompressor.compress("backup.sql");
    }
}
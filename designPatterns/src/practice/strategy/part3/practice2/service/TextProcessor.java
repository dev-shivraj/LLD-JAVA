package practice.strategy.part3.practice2.service;

import practice.strategy.part3.practice2.strategy.TextStrategy;

public class TextProcessor {

    private final TextStrategy strategy;

    public TextProcessor(TextStrategy strategy) {
        this.strategy = strategy;
    }

    public String process(String text) {
        return strategy.process(text);
    }
}
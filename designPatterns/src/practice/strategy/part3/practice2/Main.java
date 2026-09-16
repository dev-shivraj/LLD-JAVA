package practice.strategy.part3.practice2;

import practice.strategy.part3.practice2.service.TextProcessor;

public class Main {

    public static void main(String[] args) {

        TextProcessor uppercase = new TextProcessor(text -> text.toUpperCase());
        TextProcessor lowercase = new TextProcessor(text -> text.toLowerCase());
        TextProcessor reverse = new TextProcessor(text -> new StringBuilder(text).reverse().toString());

        System.out.println(uppercase.process("hello"));
        System.out.println(lowercase.process("HELLO"));
        System.out.println(reverse.process("hello"));
    }
}
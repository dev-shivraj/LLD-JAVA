package practice.flyweight.part2.example1;

import practice.flyweight.part2.example1.extrinsic.Tree;
import practice.flyweight.part2.example1.factory.TreeFactory;
import practice.flyweight.part2.example1.intrinsic.TreeType;

public class Client {

    public static void main(String[] args) {

        TreeFactory factory = new TreeFactory();

        TreeType oak1 = factory.getTreeType("Oak", "Green", "oak.png");
        TreeType oak2 = factory.getTreeType("Oak", "Green", "oak.png");
        TreeType oak3 = factory.getTreeType("Oak", "Green", "oak.png");

        TreeType pine = factory.getTreeType("Pine", "Dark Green", "pine.png");

        System.out.println("oak1 == oak2: " + (oak1 == oak2));
        System.out.println("oak2 == oak3: " + (oak2 == oak3));
        System.out.println("oak1 == pine: " + (oak1 == pine));
        System.out.println();

        Tree tree1 = new Tree(100, 200, oak1);
        Tree tree2 = new Tree(300, 400, oak2);
        Tree tree3 = new Tree(500, 600, oak3);

        tree1.draw();
        tree2.draw();
        tree3.draw();
    }
}
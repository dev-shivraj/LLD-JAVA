package practice.flyweight.part5.practice1;

import practice.flyweight.part5.practice1.extrinsic.Tree;
import practice.flyweight.part5.practice1.factory.TreeTypeFactory;
import practice.flyweight.part5.practice1.intrinsic.TreeType;

public class Client {

    public static void main(String[] args) {

        TreeTypeFactory factory = new TreeTypeFactory();

        TreeType oakType = factory.getTreeType("Oak", "oak.png", "Green", 20);
        TreeType oakTypeAgain = factory.getTreeType("Oak", "oak.png", "Green", 20);

        Tree tree1 = new Tree(10, 20, oakType);
        Tree tree2 = new Tree(50, 80, oakTypeAgain);

        tree1.render();
        tree2.render();

        System.out.println("Same TreeType object: " + (oakType == oakTypeAgain));
        System.out.println("Unique TreeTypes: " + factory.getTreeTypeCount());
    }
}
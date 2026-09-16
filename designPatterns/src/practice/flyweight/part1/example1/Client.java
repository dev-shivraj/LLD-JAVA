package practice.flyweight.part1.example1;

import practice.flyweight.part1.example1.extrinsic.Tree;
import practice.flyweight.part1.example1.intrinsic.TreeType;

public class Client {

    public static void main(String[] args) {
        TreeType oakTreeType = new TreeType("Oak", "Green", "oak.png");

        Tree tree1 = new Tree(100, 200, oakTreeType);
        Tree tree2 = new Tree(300, 400, oakTreeType);
        Tree tree3 = new Tree(500, 600, oakTreeType);

        tree1.draw();
        tree2.draw();
        tree3.draw();

        System.out.println();
        System.out.println("tree1 and tree2 share TreeType: " + (tree1.getTreeType() == tree2.getTreeType()));
        System.out.println("tree2 and tree3 share TreeType: " + (tree2.getTreeType() == tree3.getTreeType()));
    }
}
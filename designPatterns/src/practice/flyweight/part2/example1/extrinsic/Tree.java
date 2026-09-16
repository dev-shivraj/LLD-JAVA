package practice.flyweight.part2.example1.extrinsic;

import practice.flyweight.part2.example1.intrinsic.TreeType;

public class Tree {

    private final int x;
    private final int y;
    private final TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw() {
        treeType.draw(x, y);
    }

    public TreeType getTreeType() {
        return treeType;
    }
}
package practice.flyweight.part5.practice1.extrinsic;

import practice.flyweight.part5.practice1.intrinsic.TreeType;

public class Tree {

    private final int x;
    private final int y;
    private final TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void render() {
        treeType.render(x, y);
    }
}
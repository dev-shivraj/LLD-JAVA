package practice.flyweight.part3.example2.extrinsic;

import practice.flyweight.part3.example2.intrinsic.TileType;

public class MapTile {

    private final int row;
    private final int col;
    private final TileType tileType;

    public MapTile(
            int row,
            int col,
            TileType tileType
    ) {
        this.row = row;
        this.col = col;
        this.tileType = tileType;
    }

    public void render() {
        tileType.render(row, col);
    }
}
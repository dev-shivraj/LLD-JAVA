package practice.flyweight.part3.practice3.extrinsic;

import practice.flyweight.part3.practice3.intrinsic.SoldierType;

public class Soldier {

    private final String id;
    private final int x;
    private final int y;
    private final int health;
    private final SoldierType soldierType;

    public Soldier(
            String id,
            int x,
            int y,
            int health,
            SoldierType soldierType
    ) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.health = health;
        this.soldierType = soldierType;
    }

    public void render() {
        soldierType.render(
                id,
                x,
                y,
                health
        );
    }

    public SoldierType getSoldierType() {
        return soldierType;
    }
}
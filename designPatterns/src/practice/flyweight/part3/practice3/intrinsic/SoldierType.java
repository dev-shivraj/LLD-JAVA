package practice.flyweight.part3.practice3.intrinsic;

public class SoldierType {

    private final String weapon;
    private final String uniform;
    private final String texture;
    private final int movementSpeed;

    public SoldierType(
            String weapon,
            String uniform,
            String texture,
            int movementSpeed
    ) {
        this.weapon = weapon;
        this.uniform = uniform;
        this.texture = texture;
        this.movementSpeed = movementSpeed;
    }

    public void render(
            String id,
            int x,
            int y,
            int health
    ) {
        System.out.println(
                "Soldier: " + id +
                " | Position: (" + x + ", " + y + ")" +
                " | Health: " + health +
                " | Weapon: " + weapon +
                " | Uniform: " + uniform +
                " | Texture: " + texture +
                " | Speed: " + movementSpeed
        );
    }
}
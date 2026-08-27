package practice.prototype.part1.game;

public class GameCharacter {
    private String name;
    private int health;
    private int attackPower;
    private Weapon weapon;

    public GameCharacter(String name, int health, int attackPower, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.weapon = weapon;
    }

    // Shallow Copy

    public GameCharacter shallowCopy() {
        return new GameCharacter(this.name, this.health, this.attackPower, this.weapon);
    }

    // Deep Copy
    public GameCharacter deepCopy() {
        return new GameCharacter(this.name, this.health, this.attackPower, this.weapon.copy());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                "health='" + health + '\'' +
                "attackPower='" + attackPower + attackPower + '\'' +
                "weapon='" + weapon + '\'' +
                "}";
    }
}

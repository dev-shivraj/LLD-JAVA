package practice.prototype.part2.prototypepattern.game;

public abstract class GameCharacter implements Prototype<GameCharacter> {
    protected String name;
    protected int health;
    protected int attackPower;
    protected Weapon weapon;

    protected GameCharacter(String name, int health, int attackPower, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.weapon = weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponDamage(int damage) {
        this.weapon.setDamage(damage);
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                ", weapon=" + weapon +
                '}';
    }
}
package practice.prototype.part2.prototypepattern.game;

public class Warrior extends GameCharacter{

    public Warrior(String name, int health, int attackPower, Weapon weapon) {
        super(name, health, attackPower, weapon);
    }

    @Override
    public Warrior copy() {
        return new Warrior(this.name, this.health, this.attackPower, this.weapon.copy());
    }
}

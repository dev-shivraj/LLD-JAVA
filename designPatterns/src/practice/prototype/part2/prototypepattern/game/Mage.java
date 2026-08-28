package practice.prototype.part2.prototypepattern.game;

public class Mage extends GameCharacter {
    public Mage(String name, int health, int attackPower, Weapon weapon) {
        super(name, health, attackPower, weapon);
    }

    @Override
    public Mage copy() {
        return new Mage(this.name, this.health, this.attackPower, this.weapon.copy());
    }

}

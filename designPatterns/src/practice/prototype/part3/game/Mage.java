package practice.prototype.part3.game;

public class Mage extends GameCharacter {
    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public Mage copy() {
        return new Mage(this.name, this.health, this.attackPower);
    }
}
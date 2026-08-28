package practice.prototype.part3.game;

public class Warrior extends GameCharacter {
    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public Warrior copy() {
        return new Warrior(this.name, this.health, this.attackPower);
    }
}
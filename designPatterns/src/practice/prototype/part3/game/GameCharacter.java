package practice.prototype.part3.game;

public abstract class GameCharacter implements Prototype<GameCharacter> {
    protected String name;
    protected int health;
    protected int attackPower;

    protected GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                '}';
    }
}
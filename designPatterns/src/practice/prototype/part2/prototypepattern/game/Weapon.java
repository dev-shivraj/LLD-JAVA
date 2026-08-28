package practice.prototype.part2.prototypepattern.game;

public class Weapon implements Prototype<Weapon> {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public Weapon copy() {
        return new Weapon(name, damage);
    }

    public String getName() {
        return name;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }
}

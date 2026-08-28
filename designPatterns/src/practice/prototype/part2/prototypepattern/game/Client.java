package practice.prototype.part2.prototypepattern.game;

public class Client {

    public static void main(String[] args) {

        Weapon sword = new Weapon("Sword", 50);
        Weapon staff = new Weapon("Staff", 30);

        Warrior warriorPrototype = new Warrior("Warrior", 100, 50, sword);
        Mage magePrototype = new Mage("Mage", 80, 70, staff);

        Warrior warrior1 = warriorPrototype.copy();
        Warrior warrior2 = warriorPrototype.copy();
        Mage mage1 = magePrototype.copy();

        warrior1.setName("Thor");
        warrior2.setName("Arjun");
        warrior1.setWeaponDamage(100);
        mage1.setName("Gandalf");


        System.out.println("Warrior Prototype: " + warriorPrototype);
        System.out.println("Warrior 1: " + warrior1);
        System.out.println("Warrior 2: " + warrior2);
        System.out.println("Mage Prototype: " + magePrototype);
        System.out.println("Mage 1: " + mage1);

        System.out.println();
        System.out.println("warrior1 == warriorPrototype: " + (warrior1 == warriorPrototype));
        System.out.println("warrior1.weapon == warriorPrototype.weapon: " + (warrior1.weapon == warriorPrototype.weapon));
    }
}
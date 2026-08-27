package practice.prototype.part1.game;

public class Client {
    public static void main(String[] args) {
        Weapon sword = new Weapon("Sword", 50);
        GameCharacter warriorPrototype = new GameCharacter("Warrior", 100, 50, sword);

        System.out.println("===== SHALLOW COPY =====");
        GameCharacter warrior1 = warriorPrototype.shallowCopy();

        GameCharacter warrior2 = warriorPrototype.shallowCopy();

        warrior1.setName("Thor");
        warrior2.setName("Arjun");

        System.out.println("Before weapon modification:");
        System.out.println("Warrior 1: " + warrior1);
        System.out.println("Warrior 2: " + warrior2);

        warrior1.getWeapon().setDamage(100);

        System.out.println();
        System.out.println("After warrior1 weapon damage modification:");
        System.out.println("Warrior 1: " + warrior1);
        System.out.println("Warrior 2: " + warrior2);

        System.out.println();
        System.out.println("Same weapon object? " + (warrior1.getWeapon() == warrior2.getWeapon()));


        System.out.println();
        System.out.println("===== DEEP COPY =====");

        GameCharacter warrior3 = warriorPrototype.deepCopy();
        GameCharacter warrior4 = warriorPrototype.deepCopy();

        warrior3.setName("Thor");
        warrior4.setName("Arjun");

        System.out.println("Before weapon modification:");
        System.out.println("Warrior 3: " + warrior3);
        System.out.println("Warrior 4: " + warrior4);

        warrior3.getWeapon().setDamage(200);

        System.out.println();
        System.out.println("After warrior3 weapon damage modification:");
        System.out.println("Warrior 3: " + warrior3);
        System.out.println("Warrior 4: " + warrior4);

        System.out.println();
        System.out.println("Same weapon object? " + (warrior3.getWeapon() == warrior4.getWeapon()));
    }
}
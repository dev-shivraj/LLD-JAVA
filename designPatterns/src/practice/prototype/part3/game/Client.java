package practice.prototype.part3.game;

public class Client {

    public static void main(String[] args) {
        PrototypeRegistry registry = new PrototypeRegistry();

        Warrior warriorPrototype = new Warrior("Warrior", 100, 50);
        Mage magePrototype = new Mage("Mage", 80, 70);

        registry.register("warrior", warriorPrototype);
        registry.register("mage", magePrototype);

        Warrior warrior1 = registry.get("warrior");
        Warrior warrior2 = registry.get("warrior");
        Mage mage1 = registry.get("mage");

        warrior1.setName("Thor");
        warrior2.setName("Arjun");
        mage1.setName("Gandalf");

        System.out.println("Warrior Prototype: " + warriorPrototype);
        System.out.println("Warrior 1: " + warrior1);
        System.out.println("Warrior 2: " + warrior2);
        System.out.println("Mage Prototype: " + magePrototype);
        System.out.println("Mage 1: " + mage1);
    }
}
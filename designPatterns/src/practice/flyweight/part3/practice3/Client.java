package practice.flyweight.part3.practice3;

import practice.flyweight.part3.practice3.extrinsic.Soldier;
import practice.flyweight.part3.practice3.factory.SoldierTypeFactory;
import practice.flyweight.part3.practice3.intrinsic.SoldierType;

public class Client {

    public static void main(String[] args) {

        SoldierTypeFactory factory = new SoldierTypeFactory();

        SoldierType infantry =factory.getSoldierType("Rifle", "Green", "infantry.png", 5);
        SoldierType infantryAgain =factory.getSoldierType("Rifle", "Green", "infantry.png", 5);
        SoldierType sniper =factory.getSoldierType("Sniper Rifle", "Camouflage", "sniper.png", 3);

        Soldier soldier1 =new Soldier("S1", 100, 200, 100,infantry);
        Soldier soldier2 =new Soldier("S2", 300, 400, 90,infantryAgain);
        Soldier soldier3 =new Soldier("S3", 500, 600, 100,sniper);

        soldier1.render();
        soldier2.render();
        soldier3.render();

        System.out.println();
        System.out.println("infantry == infantryAgain: " + (infantry == infantryAgain));
        System.out.println("infantry == sniper: " + (infantry == sniper));
        System.out.println("soldier1 and soldier2 share type: " + (soldier1.getSoldierType() == soldier2.getSoldierType()));
    }
}
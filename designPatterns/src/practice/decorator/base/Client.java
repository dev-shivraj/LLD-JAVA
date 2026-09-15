package practice.decorator.base;

import practice.decorator.base.component.Coffee;
import practice.decorator.base.component.Espresso;
import practice.decorator.base.decorator.Moka;
import practice.decorator.base.decorator.Whip;

public class Client {

    public static void main(String[] args) {
      //  Coffee coffee = new Decaf();
//
//        System.out.println(coffee.cost());
//        System.out.println(coffee.description());
//
//        Condiment condiment = new Whip(coffee);
//        System.out.println(condiment.cost());
//        System.out.println(condiment.description());

        Coffee coffee = new Whip(new Moka(new Espresso()));

        System.out.println(coffee.cost());
        System.out.println(coffee.description());
    }
}
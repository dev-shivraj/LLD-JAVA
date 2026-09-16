package practice.flyweight.part2.practice2;

import practice.flyweight.part2.practice2.extrinsic.Particle;
import practice.flyweight.part2.practice2.factory.ParticleFactory;
import practice.flyweight.part2.practice2.intrinsic.ParticleType;

public class Client {

    public static void main(String[] args) {

        ParticleFactory factory = new ParticleFactory();

        ParticleType smoke1 = factory.getParticleType("smoke.png", "Gray");
        ParticleType smoke2 = factory.getParticleType("smoke.png", "Gray");
        ParticleType fire = factory.getParticleType("fire.png", "Orange");

        Particle particle1 = new Particle(100, 200, 2, 3, smoke1);
        Particle particle2 = new Particle(300, 400, 1, 2, smoke2);
        Particle particle3 = new Particle(500, 600, 3, 1, fire);

        particle1.render();
        particle2.render();
        particle3.render();

        System.out.println();
        System.out.println("smoke1 == smoke2: " + (smoke1 == smoke2));
        System.out.println("smoke1 == fire: " + (smoke1 == fire));
        System.out.println("particle1 and particle2 share type: " + (particle1.getParticleType() == particle2.getParticleType()));
    }
}
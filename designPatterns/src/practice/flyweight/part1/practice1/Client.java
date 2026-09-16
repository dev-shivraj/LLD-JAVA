package practice.flyweight.part1.practice1;

import practice.flyweight.part1.practice1.extrinsic.Particle;
import practice.flyweight.part1.practice1.intrinsic.ParticleType;

public class Client {

    public static void main(String[] args) {

        ParticleType smoke = new ParticleType("smoke.png", "Gray");

        Particle particle1 = new Particle(100, 200, 2, 3, smoke);
        Particle particle2 = new Particle(300, 400, 1, 2, smoke);
        Particle particle3 = new Particle(500, 600, 3, 1, smoke);

        particle1.render();
        particle2.render();
        particle3.render();

        System.out.println();
        System.out.println("particle1 and particle2 share ParticleType: " + (particle1.getParticleType() == particle2.getParticleType()));
        System.out.println("particle2 and particle3 share ParticleType: " + (particle2.getParticleType() == particle3.getParticleType()));
    }
}
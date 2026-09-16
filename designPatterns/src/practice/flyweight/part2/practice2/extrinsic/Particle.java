package practice.flyweight.part2.practice2.extrinsic;

import practice.flyweight.part2.practice2.intrinsic.ParticleType;

public class Particle {

    private final int x;
    private final int y;
    private final int velocityX;
    private final int velocityY;
    private final ParticleType particleType;

    public Particle(
            int x,
            int y,
            int velocityX,
            int velocityY,
            ParticleType particleType
    ) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.particleType = particleType;
    }

    public void render() {
        particleType.render(x, y);
    }

    public ParticleType getParticleType() {
        return particleType;
    }
}
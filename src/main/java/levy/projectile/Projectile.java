package levy.projectile;

import static java.lang.Math.sin;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private final double gravity = 9.8;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return sin(radians) * velocity * seconds - 0.5 * gravity * seconds * seconds;
    }

    public double getApexTime() {
        return velocity * sin(radians) / gravity;
    }

    public double getPeakY() {
        return ((sin(radians) * velocity) * (sin(radians) * velocity)) / 2 * gravity;
    }
}



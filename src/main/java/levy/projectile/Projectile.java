package levy.projectile;

import static java.lang.Math.sin;

public class Projectile {
    public double angle;
    public double radians;
    public double velocity;
    public double seconds;
    public double apexTime;
    public double peakY;

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
        return sin(radians) * velocity * seconds - 0.5 * 9.8 * seconds * seconds;
    }

    public double getApexTime() {
        return velocity * sin(radians) / 9.8;
    }

    public double getPeakY() {
        return ((sin(radians) * velocity) * (sin(radians) * velocity)) / 19.6;
    }
}



package levy.projectile;

public class projectile {
    private double angle;
    private double radians;
    private double velocity;
    private double seconds;
    private double apexTime;

    public projectile(double angle, double velocity) {
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
        return Math.sin(radians) * velocity * seconds - 0.5 * 9.8
                * seconds * seconds;
    }

    public double getApexTime() {
        return velocity * Math.sin(radians) / 9.8;
    }
}


package levy.projectile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectileTest {

    @Test
    public void testGetX() {
        // given
        Projectile p = new Projectile(31, 65);
        p.setSeconds(2.7);

        // when
        double actual = p.getX();

        // then
        assertEquals(150.43, actual, 0.01);
    }

    @Test
    public void testGetY() {
        // given
        Projectile p = new Projectile(31, 65);
        p.setSeconds(2.7);

        // when
        double actual = p.getY();

        // then
        assertEquals(54.66, actual, 0.01);
    }

    @Test
    public void testGetApexTime() {
        // given
        Projectile p = new Projectile(31, 65);
        p.setSeconds(2.7);

        // when
        double actual = p.getApexTime();

        // then
        assertEquals(3.41, actual, 0.01);
    }

    @Test
    public void testPeakY() {
        // given
        Projectile p = new Projectile(31, 65);
        p.setSeconds(2.7);

        // when
        double actual = p.getPeakY();

        // then
        assertEquals(57.18, actual, 0.01);
    }

    @Test
    public void getInterceptX() {
        // given
        Projectile projectile = new Projectile(31, 65);

        // when
        double actual = projectile.getInterceptX();

        // then
        assertEquals(380.65, actual, 0.01);
    }
}


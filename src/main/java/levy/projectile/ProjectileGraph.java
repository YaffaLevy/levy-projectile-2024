package levy.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0, 0);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight());
        g.setColor(Color.BLUE);
        g.fillOval((int) projectile.getInterceptX() / 2 - 5, (int) -projectile.getPeakY() - 5, 10, 10);
        int nowX;
        int nowY;

        projectile.setSeconds(0);

        for (int t = 0; t <= projectile.getApexTime() * 2 + 1; t++) {
            g.setColor(Color.BLACK);
            nowX = (int) projectile.getX();
            nowY = (int) projectile.getY();
            projectile.setSeconds(t);
            g.drawLine(nowX, -nowY, (int) projectile.getX(), (int) -projectile.getY());

        }

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }
}


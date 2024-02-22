package levy.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0,0);
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());
        g.drawString("(100, 100)", 100, -100);
        g.setColor(Color.CYAN);
        g.drawLine(0, 0, getWidth(), -getHeight());
        g.drawRect(200, -200, 50, 50);
        g.setColor(Color.MAGENTA);
        g.fillRect(200, -200, 50, 50);
        g.setColor(Color.ORANGE);
        g.drawOval(200, -200, 50, 50);

        g.fillOval(
                (int) projectile.getX(),
                (int) -projectile.getY(),
                10,
                10
        );
    }

        public void setProjectile(Projectile projectile){
            this.projectile = projectile;
            repaint();
        }
}

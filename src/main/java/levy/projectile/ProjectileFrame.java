package levy.projectile;

import javax.swing.*;
import java.awt.*;


public class ProjectileFrame extends JFrame {

    private final JTextField velocityField;

    private final JSlider angleSlider;

    private final JTextField secondsField;
    private final JLabel nothingX;
    private final JLabel nothingY;
    private final JLabel nothingPeakY;
    private final JLabel interceptNothingX;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");

        final int fpsMin = 0;
        final int fpsMax = 90;
        final int fpsInit = 45;
        angleSlider = new JSlider(JSlider.HORIZONTAL,
                fpsMin, fpsMax, fpsInit);
        angleSlider.addChangeListener(e -> calculate());


        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);


        velocityField = new JTextField();

        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> calculate());
        secondsField = new JTextField("0");

        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) e -> calculate());

        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        add(velocityField);

        add(secondsLabel);
        add(secondsField);

        add(angleLabel);
        add(angleSlider);

        JLabel xLabel = new JLabel("X");
        add(xLabel);
        nothingX = new JLabel("");
        add(nothingX);

        JLabel yLabel = new JLabel("Y");
        add(yLabel);
        nothingY = new JLabel(" ");
        add(nothingY);

        JLabel peakY = new JLabel("Peak Y");
        add(peakY);
        nothingPeakY = new JLabel();
        add(nothingPeakY);

        JLabel interceptX = new JLabel("Intercept X");
        add(interceptX);
        interceptNothingX = new JLabel();
        add(interceptNothingX);

        JLabel empty = new JLabel();
        add(empty);

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        calculateButton.addActionListener(e -> calculate());
    }


    public void calculate() {
        Projectile projectile = new Projectile(angleSlider.getValue(),
                Double.parseDouble(velocityField.getText()));
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText()));
        nothingX.setText(Double.toString(projectile.getX()));
        nothingY.setText(Double.toString(projectile.getY()));
        nothingPeakY.setText(Double.toString(projectile.getPeakY()));
        interceptNothingX.setText(Double.toString(projectile.getInterceptX()));
    }
}

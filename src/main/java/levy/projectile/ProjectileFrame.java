package levy.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    private final JTextField velocityField;

    private final JSlider angleSlider;

    private final JTextField secondsField;
    private final JLabel xNothing;
    private final JLabel yNothing;
    private final JLabel peakYNothing;
    private final JLabel interceptXNothing;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        xNothing = new JLabel("");
        JLabel yLabel = new JLabel("Y");
        yNothing = new JLabel(" ");
        JLabel empty = new JLabel();
        JLabel peakY = new JLabel("Peak Y");
        peakYNothing = new JLabel();
        JLabel interceptX = new JLabel("Intercept X");
        interceptXNothing = new JLabel();

        final int fpsMin = 0;
        final int fpsMax = 90;
        final int fpsInit = 45;
        angleSlider = new JSlider(JSlider.HORIZONTAL,
                fpsMin, fpsMax, fpsInit);
        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                calculate();
            }
        });

        // Turn on labels at major tick marks.
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);


        velocityField = new JTextField();
        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
            // implement the methods
        });
        secondsField = new JTextField("0");
        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
            // implement the methods
        });

        JButton calculateButton = new JButton("Calculate");

        add(velocityLabel);
        add(velocityField);

        add(secondsLabel);
        add(secondsField);

        add(angleLabel);
        add(angleSlider);

        add(xLabel);
        add(xNothing);

        add(yLabel);
        add(yNothing);

        add(peakY);
        add(peakYNothing);

        add(interceptX);
        add(interceptXNothing);

        add(empty);
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }


        });
    }


    public void calculate() {
        Projectile projectile = new Projectile(angleSlider.getValue(),
                Double.parseDouble(velocityField.getText()));
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText()));
        xNothing.setText(Double.toString(projectile.getX()));
        yNothing.setText(Double.toString(projectile.getY()));
        peakYNothing.setText(Double.toString(projectile.getPeakY()));
        interceptXNothing.setText(Double.toString(projectile.getInterceptX()));
    }
}

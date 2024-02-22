package levy.projectile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
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

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(8, 2));

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
        west.add(velocityLabel);
        west.add(velocityField);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        west.add(secondsField);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        west.add(angleSlider);

        JLabel labelX = new JLabel("X");
        west.add(labelX);
        nothingX = new JLabel("");
        west.add(nothingX);

        JLabel labelY = new JLabel("Y");
        west.add(labelY);
        nothingY = new JLabel(" ");
        west.add(nothingY);

        JLabel peakY = new JLabel("Peak Y");
        west.add(peakY);
        nothingPeakY = new JLabel();
        west.add(nothingPeakY);

        JLabel interceptX = new JLabel("Intercept X");
        west.add(interceptX);
        interceptNothingX = new JLabel();
        west.add(interceptNothingX);

        JLabel empty = new JLabel();
        west.add(empty);

        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

        calculateButton.addActionListener(e -> calculate());

        ProjectileGraph graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);
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

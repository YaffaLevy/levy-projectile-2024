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
    private final JLabel Xnothing;
    private final JLabel Ynothing;
    private final JLabel PeakYnothing;
    private final JLabel InterceptXnothing;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel XLabel = new JLabel("X");
        Xnothing = new JLabel("");
        JLabel YLabel = new JLabel("Y");
        Ynothing = new JLabel(" ");
        JLabel empty = new JLabel();
        JLabel PeakY = new JLabel("Peak Y");
        PeakYnothing = new JLabel();
        JLabel InterceptX = new JLabel("Intercept X");
        InterceptXnothing = new JLabel();

        final int FPS_MIN = 0;
        final int FPS_MAX = 90;
        final int FPS_INIT = 45;
        angleSlider = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN, FPS_MAX, FPS_INIT);
        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                calculate();
            }
        });

//Turn on labels at major tick marks.
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

        JButton calculate = new JButton("Calculate");

        add(velocityLabel);
        add(velocityField);

        add(secondsLabel);
        add(secondsField);

        add(angleLabel);
        add(angleSlider);

        add(XLabel);
        add(Xnothing);

        add(YLabel);
        add(Ynothing);

        add(PeakY);
        add(PeakYnothing);

        add(InterceptX);
        add(InterceptXnothing);

        add(empty);
        add(calculate);

        calculate.addActionListener(new ActionListener() {
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
        Xnothing.setText(Double.toString(projectile.getX()));
        Ynothing.setText(Double.toString(projectile.getY()));
        PeakYnothing.setText(Double.toString(projectile.getPeakY()));
        InterceptXnothing.setText(Double.toString(projectile.getInterceptX()));
    }
}



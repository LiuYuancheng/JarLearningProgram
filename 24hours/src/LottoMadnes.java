
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LottoMadnes extends JFrame {

    JPanel row1 = new JPanel();
    ButtonGroup option = new ButtonGroup();
    JCheckBox quickpick = new JCheckBox("Quick Pick", false);
    JCheckBox personal = new JCheckBox("Personal", true);

    JPanel row2 = new JPanel();
    JLabel numLabel = new JLabel("You pick :", JLabel.RIGHT);
    JTextField[] numbers = new JTextField[6];
    JLabel winLb = new JLabel("Winners :", JLabel.RIGHT);
    JTextField[] winners = new JTextField[6];

    JPanel row3 = new JPanel();
    JButton play = new JButton("Play");
    JButton pause = new JButton("Pause");
    JButton stop = new JButton("Stop");

    JPanel row4 = new JPanel();
    JLabel got3Lb = new JLabel("3 of 6", JLabel.RIGHT);
    JTextField got3Tf = new JTextField("0");
    JLabel got4Lb = new JLabel("4 of 6", JLabel.RIGHT);
    JTextField got4Tf = new JTextField("0");
    JLabel got5Lb = new JLabel("5 of 6", JLabel.RIGHT);
    JTextField got5Tf = new JTextField("0");
    JLabel got6Lb = new JLabel("6 of 6", JLabel.RIGHT);
    JTextField got6Tf = new JTextField("0", 10);

    JLabel drawLb = new JLabel("Drawings:", JLabel.RIGHT);
    JTextField drawTf = new JTextField("0");
    JLabel yearLb = new JLabel("Years:", JLabel.RIGHT);
    JTextField yearTf = new JTextField();

    public LottoMadnes() {
        super("Lotto Madness.");
        setSize(550, 270);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GridLayout layout = new GridLayout(5, 1, 10, 10);
        setLayout(layout);

        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        option.add(quickpick);
        option.add(personal);
        row1.setLayout(layout1);
        row1.add(quickpick);
        row1.add(personal);
        add(row1);

        GridLayout layout2 = new GridLayout(2, 7, 10, 10);
        row2.setLayout(layout2);
        row2.add(numLabel);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JTextField();
            row2.add(numbers[i]);
        }

        row2.add(winLb);
        for (int i = 0; i < winners.length; i++) {
            winners[i] = new JTextField();
            winners[i].setEditable(false);
            row2.add(winners[i]);
        }
        add(row2);

        FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        row3.setLayout(layout3);
        row3.add(play);
        row3.add(pause);
        row3.add(stop);
        add(row3);

        GridLayout layout4 = new GridLayout(2, 3, 10, 10);
        row4.setLayout(layout4);

        row4.add(got3Lb);
        got3Tf.setEditable(false);
        row4.add(got3Tf);

        row4.add(got4Lb);
        got3Tf.setEditable(false);
        row4.add(got4Tf);

        row4.add(got5Lb);
        got3Tf.setEditable(false);
        row4.add(got5Tf);

        row4.add(got6Lb);
        got3Tf.setEditable(false);
        row4.add(got6Tf);

        row4.add(drawLb);
        got3Tf.setEditable(false);
        row4.add(drawTf);

        row4.add(yearLb);
        got3Tf.setEditable(false);
        row4.add(yearTf);
        
        setVisible(true);
    }
}
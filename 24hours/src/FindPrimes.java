
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FindPrimes extends JFrame implements Runnable, ActionListener {
    Thread go;
    JLabel countLB = new JLabel("Quantity: ");
    JTextField countTF = new JTextField("400", 10);
    JButton display = new JButton("Show primes");
    JTextArea primes = new JTextArea(8, 40);

    FindPrimes() {
        super("Find the primes in a number range");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        display.addActionListener(this);

        JPanel topPanel = new JPanel();
        topPanel.add(countLB);
        topPanel.add(countTF);
        topPanel.add(display);
        add(topPanel, BorderLayout.NORTH);

        primes.setLineWrap(true);
        JScrollPane textPane = new JScrollPane(primes);
        add(textPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        display.setEnabled(false);
        if (go == null) {
            go = new Thread(this);
            go.start();
            return;
        }
        go.start();
    }

    public void run() {
        int quantity = Integer.parseInt(countTF.getText());
        int numPrimes = 0;
        int candidate = 2;
        primes.append("First " + quantity + "primes:");
        while (numPrimes < quantity) {
            if (isPrime(candidate)) {
                primes.append("" + candidate + ",");
                numPrimes++;
            }
            candidate++;
        }
    }

    public static boolean isPrime(int num) {
        double root = Math.sqrt(num);
        for (int i = 2; i < root; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}

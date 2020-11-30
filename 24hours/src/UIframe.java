import java.awt.*;
import javax.swing.*;

public class UIframe {

    public UIframe(int choice) {

        switch (choice) {
            case 0:
                Player frame = new Player("img/OT_PlatForm.jpg");
            default:
                System.out.println("The input" + choice + "is not valid.");
        }
    }
}

class Player extends JFrame {
    public Player(String imgPath) {
        super("Player");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PlayerPanel fp = new PlayerPanel(imgPath);
        add(fp);
        setVisible(true);
    }
}

class PlayerPanel extends JPanel {
    public PlayerPanel(String imgPath) {
        ImageIcon player = new ImageIcon(imgPath);
        add(new JLabel(player));
    }

    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        // comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.KEY_ALPHA_INTERPOLATION);
        int w = getSize().width;
        int h = getSize().height;
        Font crtFont = new Font("Dialog", Font.BOLD, 18);
        comp2D.setFont(crtFont);
        comp2D.drawString("OT Railway Simulation moduel", w - 255, h - 55);
        crtFont = new Font("Dialog", Font.ITALIC, 12);
        comp2D.setFont(crtFont);
        comp2D.drawString("Program Running Env", w - 255, h - 30);
        crtFont = new Font("Dialog", Font.PLAIN, 12);
        comp2D.drawString("Webpage View", w - 255, h - 10);
    }
}
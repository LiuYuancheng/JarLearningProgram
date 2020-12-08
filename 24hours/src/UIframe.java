import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

//-----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
public class UIframe {

    public UIframe(int choice) {

        switch (choice) {
            case 1:
                Player frame0 = new Player("img/OT_PlatForm.jpg");
                break;
            case 2:
                DangerFrame frame1 = new DangerFrame();
                break;
            case 3:
                Sign sign = new Sign();
            default:
                System.out.println("The input" + choice + "is not valid.");
        }
    }
}

//-----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
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

// -----------------------------------------------------------------------------
class PlayerPanel extends JPanel {

    Color lightOrg = new Color(230, 220, 0);
    Color darkRed = new Color(235, 50, 50);

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
        comp2D.setColor(lightOrg);
        comp2D.drawString("OT Railway Simulation moduel", w - 255, h - 55);
        crtFont = new Font("Dialog", Font.ITALIC, 12);
        comp2D.setFont(crtFont);
        comp2D.drawString("Program Running Env", w - 255, h - 30);
        crtFont = new Font("Dialog", Font.PLAIN, 12);
        comp2D.drawString("Webpage View", w - 255, h - 10);
        comp2D.setColor(darkRed);
        comp2D.fillRect(20, 500, 30, 20);
    }
}

//-----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
class DangerFrame extends JFrame{
    public DangerFrame(){
        super("Warning!");
        setSize(400, 80);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DangerPnl gb = new DangerPnl("Warning string.");
        add(gb);
        setVisible(true);
    }
}

// -----------------------------------------------------------------------------
class DangerPnl extends JPanel implements Runnable{
    String text = "No text has been specified.";
    float hue = (float)0.5;
    float saturation = (float)0.8;
    float brightness = (float)0.0;
    Font textFont = new Font("Dialog", Font.BOLD, 20);
    int textX; 
    Thread runner;

    public DangerPnl(String warningMsg){
        text = warningMsg;
        FontMetrics fm = getFontMetrics(textFont);
        // text position.
        textX = 200 - fm.stringWidth(text)/2;
        runner = new Thread(this);
        runner.start();
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D) comp;


        comp2D.setColor(Color.black);
        comp2D.fillRect(0, 0, 400, 200);
        Color textColor = Color.getHSBColor(hue, saturation, brightness);
        comp2D.setColor(textColor);
        comp2D.setFont(textFont);
        comp2D.drawString(text, textX, 30);
    }

    void pause(int duration){
        try{
            Thread.sleep(duration);
        }catch(InterruptedException exception){
            System.out.println("Exception: " + exception.toString());
        }
    }

    public void run(){
        Thread thisThread = Thread.currentThread();
        while( runner == thisThread){
            pause(75);
            brightness += 0.05;
            if(brightness > 1){
                brightness = (float)0.0;
                pause(75);
            }
            repaint();
        }
    }
}
//-----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
class Sign extends JFrame {
    public Sign() {
        super("Use of Compressed Air Prohibited");
        setSize(410, 435);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SignPnl sp = new SignPnl();
        add(sp);
        setVisible(true);
    }
}
// -----------------------------------------------------------------------------

class SignPnl extends JPanel {
    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.white);
        comp2D.fillRect(0, 0, 400, 400);

        // draw sign
        comp2D.setColor(Color.red);
        Ellipse2D.Float sign1 = new Ellipse2D.Float(0F, 0F, 400F, 400F);
        comp2D.fill(sign1);
        comp2D.setColor(Color.white);
        Ellipse2D.Float sign2 = new Ellipse2D.Float(55F, 55F, 290F, 290F);
        comp2D.fill(sign2);

        // draw man
        comp2D.setColor(Color.black);
        Ellipse2D.Float head = new Ellipse2D.Float(160F, 96F, 32F, 32F);
        comp2D.fill(head);
        GeneralPath body = new GeneralPath();
        body.moveTo(159F, 162F);
        body.lineTo(119F, 303F);
        body.lineTo(130F, 303F);
        body.lineTo(168F, 231F);
        body.lineTo(190F, 303F);
        body.lineTo(213F, 303F);
        body.lineTo(189F, 205F);
        body.lineTo(203F, 162F);
        body.lineTo(247F, 151F);
        body.lineTo(236F, 115F);
        body.lineTo(222F, 118F);
        body.lineTo(231F, 140F);
        body.lineTo(141F, 140F);
        body.lineTo(101F, 190F);
        body.lineTo(112F, 197F);
        body.lineTo(144F, 162F);
        body.closePath();
        comp2D.fill(body);

        // draw can
        comp2D.setColor(Color.black);
        comp2D.fillRect(251, 191, 33, 118);
        comp2D.fillRect(262, 160, 13, 31);
        GeneralPath nozzle = new GeneralPath();
        nozzle.moveTo(252F, 176F);
        nozzle.lineTo(262F, 160F);
        nozzle.lineTo(262F, 176F);
        nozzle.closePath();
        comp2D.fill(nozzle);

        // darw lines
        comp2D.setColor(Color.black);
        BasicStroke pen = new BasicStroke();
        comp2D.setStroke(pen);
        Line2D.Float ln1 = new Line2D.Float(203F, 121F, 255F, 102F);
        comp2D.draw(ln1);
        Line2D.Float ln2 = new Line2D.Float(255F, 102F, 272F, 116F);
        comp2D.draw(ln2);
        Line2D.Float ln3 = new Line2D.Float(272F, 134F, 252F, 158F);
        comp2D.draw(ln3);

        // finish sign
        comp2D.setColor(Color.red);
        GeneralPath sign3 = new GeneralPath();
        sign3.moveTo(110F, 78F);
        sign3.lineTo(321F, 289F);
        sign3.lineTo(290F, 317F);
        sign3.lineTo(81F, 107F);
        sign3.closePath();
        comp2D.fill(sign3);
    }
}

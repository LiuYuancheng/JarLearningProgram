import java.awt.*;
import javax.swing.*;

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

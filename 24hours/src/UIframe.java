import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

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
                break;
            case 4:
                PieApp pie = new PieApp();
                break;
            case 5: 
                Bounce animation = new Bounce();
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
//-----------------------------------------------------------------------------
// -----------------------------------------------------------------------------

class PieApp extends JFrame {
    Color p1 = new Color(0xCC, 0xCC, 0x99);
    Color p2 = new Color(0xCC, 0x66, 0xFF);
    Color p3 = new Color(0x66, 0x66, 0x99);
    Color p4 = new Color(0x66, 0x99, 0x66);
    Color p5 = new Color(0x33, 0xFF, 0xFF);
    Color p6 = new Color(0x33, 0xCC, 0xCC);
    Color p7 = new Color(0x66, 0x33, 0x99);
    Color p8 = new Color(0x99, 0x66, 0x33);
    Color p9 = new Color(0x66, 0x66, 0x66);
    Color p10 = new Color(0x92, 0x16, 0x33);

    public PieApp() {
        super("Pie chart frame.");
        setSize(410, 435);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PiePnl pie = new PiePnl(10);
        pie.addSlide(p1, 1306);
        pie.addSlide(p2, 1080);
        pie.addSlide(p3, 242);
        pie.addSlide(p4, 186);
        pie.addSlide(p5, 162);
        pie.addSlide(p6, 144);
        pie.addSlide(p7, 143);
        pie.addSlide(p8, 129);
        pie.addSlide(p9, 127);
        pie.addSlide(p10, 500);
        add(pie);
        setVisible(true);
    }
}

class PiePnl extends JPanel {
    private PieSlide[] slide;
    private int crt = 0;
    private float totalSz = 0F;
    private Color bg;

    public PiePnl(int slideCount) {
        slide = new PieSlide[slideCount];
        bg = getBackground();
    }

    public void addSlide(Color pc, float ps) {
        if (crt <= slide.length) {
            slide[crt] = new PieSlide(pc, ps);
            totalSz += ps;
            crt++;
        }
    }

    public void paintComponent(Graphics comp) {
        super.paintComponent(comp);
        Graphics2D comp2D = (Graphics2D) comp;
        int w = getSize().width - 10;
        int h = getSize().height - 10;
        int x = 5;
        int y = 5;
        if(w<5) x = w; 
        if(h<5) y = h;
        comp2D.setColor(bg);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
        comp2D.setColor(Color.lightGray);
        Ellipse2D.Float pie = new Ellipse2D.Float(x, y, w, h);
        comp2D.fill(pie);
        float start = 0;
        for (int i =0; i<slide.length;i++){
            float extent = slide[i].size*360F/totalSz;
            comp2D.setColor(slide[i].color);
            Arc2D.Float drawSlice = new Arc2D.Float(x, y , w, h, start, extent, Arc2D.Float.PIE);
            start += extent;
            comp2D.fill(drawSlice);
        }
    }
}

class PieSlide {
    Color color = Color.lightGray;
    float size = 0F;

    PieSlide(Color pc, float ps) {
        color = pc;
        size = ps;
    }
}
//-----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
class Bounce extends JFrame{
    public Bounce(){
        super("Tennis");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BouncePnl pnl = new BouncePnl();
        add(pnl);
        setVisible(true);
    }
}

class BouncePnl extends JPanel implements Runnable{
    Image ball, court;
    float crt = 0F;
    Thread runner;
    int xPos = 10;
    int xMv = 1;
    int yPos = -1;
    int ballh = 228;
    int ballw = 218;
    int height;

    public BouncePnl() {
        super();
        Toolkit kit = Toolkit.getDefaultToolkit();
        ball = kit.getImage("img/1s.png");
        court = kit.getImage("img/OT_PlatForm.jpg");
        runner = new Thread(this);
        runner.start();
    }

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D) comp;
        height = getSize().height - ballh;
        if (yPos == -1)
            yPos = height - 20;
        if ((court != null) && (ball != null)) {
            comp2D.drawImage(court, 0, 0, this);
            comp2D.drawImage(ball, (int) xPos, (int) yPos, this);
        }
    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread) {
            crt += (float) 0.1;
            if (crt > 3)
                crt = 0F;
            xPos += xMv;
            if (xPos > (getSize().width - ballw))
                xMv *= -1;
            if (xPos < 1)
                xMv *= -1;
            double bounce = Math.sin(crt) * height;
            yPos = (int) (height - bounce);
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}


import java.util.*; // Import the Scanner class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;

//-----------------------------------------------------------------------------
class Modem {
    static int modCount = 0;
    int speed;

    static void countAdd() {
        modCount++;
    }

    public void displaySpd() {
        System.out.println("Speed: " + speed);
    }
}

class CableModen extends Modem {
    String method = "cable connection";

    public void connect() {
        System.out.println("Connecting to the internet with " + method + ".");
    }
}

class DlsModen extends Modem {
    String method = "PLS phone connection";

    public void connect() {
        System.out.println("Connecting to the internet with " + method + ".");
    }
}

// -----------------------------------------------------------------------------
class myObj {

    static int objCont = 0;

    public myObj() {
        String objName = "obj";
        objCont++;
    }

    public static int getObjCount() {
        return objCont;
    }
}

// -----------------------------------------------------------------------------
class StringLister {
    String[] names = { "Spanky", "Alfa", "Buckwheat" };

    public StringLister(String[] moreName) {
        Vector<String> list = new Vector<String>();
        for (int i = 0; i < names.length; i++)
            list.add(names[i]);
        for (int i = 0; i < moreName.length; i++)
            list.add(moreName[i]);
        Collections.sort(list);
        for (String name : list)
            System.out.println(name);
    }
}

// -----------------------------------------------------------------------------
class Point3D extends Point {
    public int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void move(int x, int y, int z) {
        this.z = z;
        super.move(x, y);
    }

    public void translate(int x, int y, int z) {
        this.z += z;
        super.translate(x, y);
    }
}

// -----------------------------------------------------------------------------
class PlaybackFm extends JFrame {
    public PlaybackFm() {
        super("Play back");
        setSize(255, 80);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        add(new JButton("Play"));
        add(new JButton("Stop"));
        add(new JButton("Pause"));
        setVisible(true);
    }
}

// -----------------------------------------------------------------------------
class ClockFrm extends JFrame {
    public ClockFrm() {
        super("Clock");
        setSize(225, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        c24lockPnl clkPnl = new c24lockPnl();
        add(clkPnl);
        setVisible(true);
    }
}

// -----------------------------------------------------------------------------
class KeyView extends JFrame implements KeyListener {
    JTextField keyTxt = new JTextField(80);
    JLabel keyLb = new JLabel("Press any key in the text field.");

    KeyView() {
        super("KeyView");
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        keyTxt.addKeyListener(this);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add(keyLb, bord.NORTH);
        add(keyTxt, bord.CENTER);
        setVisible(true);
    }

    public void keyTyped(KeyEvent input) {
        char key = input.getKeyChar();
        keyLb.setText("You pressed: " + key);
    }

    public void keyPressed(KeyEvent input) {
        // no thing to do.
    }

    public void keyReleased(KeyEvent input) {
        // no thing to do.
    }
}

// -----------------------------------------------------------------------------
class WriteMail extends JFrame {

    public WriteMail() {
        super("Write an E-mail");
        setSize(370, 270);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // FlowLayout flo = new FlowLayout(FlowLayout.RIGHT);
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        JPanel row1 = new JPanel();
        row1.add(new JLabel("To:"));
        JTextField to = new JTextField(24);
        row1.add(to);
        add(row1);

        JPanel row2 = new JPanel();
        row2.add(new JLabel("Subject:"));
        JTextField subject = new JTextField(24);
        row2.add(subject);
        add(row2);

        JPanel row3 = new JPanel();
        row3.add(new JLabel("Message:"));
        JTextArea message = new JTextArea(4, 24);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(message, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        row3.add(message);
        add(row3);

        JPanel row4 = new JPanel();
        JButton send = new JButton("Send");
        JSlider pct = new JSlider(JSlider.HORIZONTAL, 1, 10, 2);
        pct.setMajorTickSpacing(1);
        pct.setMinorTickSpacing(1);
        pct.setPaintTicks(true);
        pct.setPaintLabels(true);

        row4.add(pct);
        row4.add(send);
        add(row4);

        setVisible(true);
    }
}

// -----------------------------------------------------------------------------
class ColorPanel extends JPanel {
    Color background;

    ColorPanel() {
        super();
        setSize(270, 30);
        background = Color.red;
    }

    public void paintComponent(Graphics comp) {
        // System.out.print("-Paint the panel.");
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(background);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
    }

    public void changeColor(Color newBg) {
        this.background = newBg;
    }
}

class ColorSlider extends JFrame implements ChangeListener {
    ColorPanel canves = new ColorPanel();
    JSlider red = new JSlider(0, 255, 255);
    JSlider green = new JSlider(0, 255, 0);
    JSlider blue = new JSlider(0, 255, 0);

    public ColorSlider() {
        super("Color slider");
        setSize(270, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // FlowLayout flo = new FlowLayout(FlowLayout.RIGHT);
        setVisible(true);

        red.setMajorTickSpacing(50);
        red.setMinorTickSpacing(10);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        red.addChangeListener(this);

        green.setMajorTickSpacing(50);
        green.setMinorTickSpacing(10);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        green.addChangeListener(this);

        blue.setMajorTickSpacing(50);
        blue.setMinorTickSpacing(10);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);
        blue.addChangeListener(this);

        setLayout(new GridLayout(4, 1));
        FlowLayout flo = new FlowLayout(FlowLayout.RIGHT);

        JPanel redPnl = new JPanel();
        redPnl.setLayout(flo);
        redPnl.add(new JLabel("Red: "));
        redPnl.add(red);
        add(redPnl);

        JPanel greenPnl = new JPanel();
        greenPnl.setLayout(flo);
        greenPnl.add(new JLabel("Green: "));
        greenPnl.add(green);
        add(greenPnl);

        JPanel bluePnl = new JPanel();
        bluePnl.setLayout(flo);
        bluePnl.add(new JLabel("Blue: "));
        bluePnl.add(blue);
        add(bluePnl);

        add(canves);
        canves.repaint();
        // setLayout(new FlowLayout(FlowLayout.RIGHT));
        setVisible(true);
    }

    public void stateChanged(ChangeEvent evt) {
        JSlider src = (JSlider) evt.getSource();
        if (src.getValueIsAdjusting() != true) {
            Color crtColor = new Color(red.getValue(), green.getValue(), blue.getValue());
            canves.changeColor(crtColor);
            // System.out.print("repaint the panel.");
            canves.repaint();
        }
    }

    public Insets getInsets() {
        return new Insets(45, 10, 10, 10);
    }
}

// -----------------------------------------------------------------------------
class Tool extends JFrame {
    public Tool() {
        super("Tool");
        setSize(270, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JMenuBar jmb = new JMenuBar();
        JMenu m1 = new JMenu("Start");
        m1.add(new JMenuItem("Item 1"));
        m1.add(new JMenuItem("Item 2"));
        m1.addSeparator();
        m1.add(new JMenuItem("Item 3"));
        m1.add(new JMenuItem("Item 4"));
        jmb.add(m1);

        JButton bt1 = new JButton(new ImageIcon("img/word.gif"));
        JButton bt2 = new JButton(new ImageIcon("img/excel.gif"));
        JButton bt3 = new JButton(new ImageIcon("img/ppt.gif"));

        JToolBar bar = new JToolBar();
        bar.add(bt1);
        bar.add(bt2);
        bar.add(bt3);

        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scoll = new JScrollPane();

        BorderLayout border = new BorderLayout();
        setLayout(border);
        add("North", bar);
        add("Center", scoll);
        setVisible(true);
    }

}

// -----------------------------------------------------------------------------
class HomePage {
    String owner;
    URL address;
    String category = "none";

    public HomePage(String inOwner, String inAddr) throws MalformedURLException {
        owner = inOwner;
        address = new URL(inAddr);
    }

    public HomePage(String inOwner, String inAddr, String category) throws MalformedURLException {
        this(inOwner, inAddr);
        this.category = category;
    }
}

// -----------------------------------------------------------------------------
class TagCleaner {
    public TagCleaner(String filename) {
        try {
            // Load the properity:
            File propFile = new File("CleanTag.properties");
            FileInputStream propStream = new FileInputStream(propFile);
            Properties props = new Properties();
            props.load(propStream);
            String caseProp = props.getProperty("case");
            String hideProp = props.getProperty("hideOutput");
            // load the html file:
            File file = new File(filename);
            FileInputStream in = new FileInputStream(file);
            File clean = new File(filename + ".clean");
            FileOutputStream out = new FileOutputStream(clean);
            boolean eof = false;
            boolean inTag = false;
            boolean inQuote = false;
            if (hideProp.equals("false")) {
                System.out.println("Creating file ...");
            }
            while (!eof) {
                int input = in.read();
                if (input == -1) {
                    eof = true;
                    continue;
                }

                if (input == '"') {
                    inQuote = !inQuote;
                }

                if (input == '<')
                    inTag = true;

                if (input == '>') {
                    inTag = inQuote = false;
                }

                if ((!inTag) | (inQuote)) {
                    out.write((char) input);
                } else {
                    if (caseProp.equals("lower")) {
                        out.write(Character.toLowerCase((char) input));
                    } else {
                        out.write(Character.toUpperCase((char) input));
                    }
                }
            }
            in.close();
            out.close();
            if (hideProp.equals("fase")) {
                System.out.println("Finished!");
            }

        } catch (Exception err) {
            System.out.print("Error: " + err.toString());
            return;
        }

    }
}

// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
class B24hours {
    public static void main(String[] args) {
        int choice = 1;
        Scanner myObj = new Scanner(System.in);
        while (choice > 0) {
            System.out.println("Enter your choice(0-20), 0 for stop:");
            // choice = myObj.nextInt();
            String choiceStr = myObj.nextLine();
            // System.out.println("Input: " + choice);
            choiceStr = choiceStr.replace("\n", "");
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("The input must be a number. ");
                choice = 1;
                continue;
            } catch (Exception e) {
                System.out.println("Exception:" + e.toString());
                choice = 1;
                continue;
            } finally {
                System.out.println("Input: " + choice);
            }

            switch (choice) {
                case 0:
                    System.out.println("Program terminate...");
                    break;
                case 1:
                    section1();
                    break;
                case 5:
                    section5();
                    break;
                case 6:
                    section6();
                    break;
                case 7:
                    section7(myObj);
                    break;
                case 8:
                    section8();
                    break;
                case 9:
                    section9();
                    break;
                case 10:
                    section10();
                    break;
                case 11:
                    section11();
                    break;
                case 12:
                    section12();
                    break;
                case 13:
                    section13(myObj);
                    break;
                case 14:
                    section14();
                    break;
                case 15:
                    section15(myObj);
                    break;
                case 16:
                    section16(myObj);
                    break;
                case 18:
                    section18();
                    break;
                case 19:
                    section19();
                    break;
                case 20:
                    section20(myObj);
                    break;
                default:
                    System.out.println("The input" + choice + "is not valid.");
            }
        }
    }

    public static void section1() {
        System.out.println(" 0:\tTerminate program. \n" + " 1:\tShow the input list. \n" + " 5:\tParameter define. \n"
                + " 6:\tString and characters.\n" + " 7:\tProgram control flow.\n" + " 8:\tLooping.\n"
                + " 9:\tArray and list.\n" + "10:\tObject oriented programming.\n" + "11.\tDescription object.\n"
                + "12.\tVector test.\n" + "13.\tApplication GUI.\n" + "14.\tApplication layout.\n"
                + "15.\tUI user input listener.\n" + "16.\tCreate complex UI.\n" + "18.\tException handling.\n"
                + "19.\tMulti-Threading program.\n" + "20.\tFile IO.");
    }

    public static void section5() {
        System.out.println("section 5: Parameter define.");
        int x = 10;
        int answer = x++ * 10;
        System.out.println("answer = x++*10, answer = " + answer);
        x = 10;
        answer = ++x * 10;
        System.out.println("answer = ++x*10, answer = " + answer);
    }

    public static void section6() {
        System.out.println("section 6: String and characters.");
        System.out.println("Java special chars: \', \", \\, \t, \b, \r, \f, \n ");

        String title = "The Piano";
        int year = 1987;
        String director = "Jane Camption";
        String role1 = "Ada";
        String actor1 = "Holly Hunter";

        String role2 = "Baines";
        String actor2 = "Harvey keitel";

        System.out.print(title + "( year: " + year + ")" + "A " + director + "film \n\n" + role1 + "\t" + actor1 + "\n"
                + role2 + "\t" + actor2 + "\n");
    }

    public static void section7(Scanner myObj) {
        System.out.println("section 7: Program control flow.");
        System.out.println("Time Zone: ");
        String[] ids = TimeZone.getAvailableIDs();
        for (int i = 0; i < ids.length; i++)
            System.out.println("" + i + ":\t" + ids[i].toString());
        System.out.println("input time Zone: ");
        int tz = myObj.nextInt();
        if (tz >= ids.length || tz < 0)
            System.out.println("The input idx " + tz + "is not valid.");
        else
            TimeZone.setDefault(TimeZone.getTimeZone(ids[tz]));
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int mins = now.get(Calendar.MINUTE);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.YEAR);
        int numOfEnemise = (hour > 6) ? 10 : 5;
        System.out.println(" hour: \t" + hour);
        System.out.println(" mins: \t" + mins);
        System.out.println(" month:" + month);
        System.out.println(" day: \t" + day);
        System.out.println(" year: \t" + year);
        System.out.println(" numOfEnemise: \t" + numOfEnemise);
    }

    public static void section8() {
        System.out.println("section 8: Looping.");
        int count = 10;
        Calendar start = Calendar.getInstance();
        int startMin = start.get(Calendar.MINUTE);
        int startSec = start.get(Calendar.SECOND);

        start.roll(Calendar.MINUTE, true);

        int nextMin = start.get(Calendar.MINUTE);
        int nextSec = start.get(Calendar.SECOND);
        while (count < 1000000) {
            GregorianCalendar now = new GregorianCalendar();
            if (now.get(Calendar.MINUTE) >= nextMin && now.get(Calendar.SECOND) >= nextSec)
                break;
            count++;
        }
        System.out.println("The counter added " + count + "times");
    }

    public static void section9() {
        System.out.println("section 9: Array and list.");
        String str = "This is a String";
        char[] charList = str.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            charList[i] = (charList[i] == ' ') ? '.' : charList[i];
        }
        Arrays.sort(charList);
        System.out.println("New String:" + new String(charList));
    }

    public static void section10() {
        System.out.println("section 10: Object oriented programming.");
        String count = "25";
        int myCount = Integer.parseInt(count);
        System.out.println("The square root of 25 is " + Math.sqrt(myCount));

        CableModen cm = new CableModen();
        cm.countAdd();
        DlsModen dm = new DlsModen();
        dm.countAdd();
        cm.speed = 50000;
        dm.speed = 40000;
        cm.connect();
        cm.displaySpd();
        dm.connect();
        dm.displaySpd();
        System.out.println("Created " + Modem.modCount + " modens.");
    }

    public static void section11() {
        System.out.println("section 11: Description object.");
        int objnum = 5;
        myObj[] objArr = new myObj[objnum];
        for (int i = 0; i < objnum; i++) {
            objArr[i] = new myObj();
        }
        System.out.println("Created " + myObj.getObjCount() + " object.");
    }

    public static void section12() {
        System.out.println("section 12: Vector test.");
        String[] names = { "name1", "name2", "name3" };
        StringLister lister = new StringLister(names);

        Point pt1 = new Point(11, 22);
        System.out.println("pt1:(" + pt1.x + "," + pt1.y + ")");
        Point3D pt2 = new Point3D(6, 7, 24);
        System.out.println("pt2:(" + pt2.x + "," + pt2.y + "," + pt2.z + ")");
        pt1.move(10, 20);
        System.out.println("pt1:(" + pt1.x + "," + pt1.y + ")");
        pt2.move(10, 20);
        System.out.println("pt2:(" + pt2.x + "," + pt2.y + "," + pt2.z + ")");
        pt1.translate(3, 3);
        System.out.println("pt1:(" + pt1.x + "," + pt1.y + ")");
        pt2.translate(3, 3);
        System.out.println("pt2:(" + pt2.x + "," + pt2.y + "," + pt2.z + ")");
    }

    public static void section13(Scanner myObj) {
        System.out.println("section 13: Application GUI.");
        System.out.println("Enter your choice(0-3), 0 for stop:\n" + "1.\t Playback UI. \n" + "2.\t Clock UI.");
        int choice = myObj.nextInt();
        System.out.println("Input: " + choice);
        switch (choice) {
            case 0:
                break;
            case 1:
                PlaybackFm pb = new PlaybackFm();
                break;
            case 2:
                ClockFrm clkFm = new ClockFrm();
                break;
            default:
                System.out.println("The input" + choice + "is not valid.");
        }
    }

    public static void section14() {
        System.out.println("section 14: Application layout.");
        LottoMadnes frame = new LottoMadnes();
    }

    public static void section15(Scanner myObj) {
        System.out.println("section 15: UI user input listener.");

        System.out.println(
                "Enter your choice(0-3), 0 for stop:\n" + "1.\t KeyView press UI. \n" + "2.\t LottoMadnes UI.");
        int choice = myObj.nextInt();
        System.out.println("Input: " + choice);

        switch (choice) {
            case 0:
                break;
            case 1:
                KeyView kv = new KeyView();
                break;
            case 2:
                LottoMadnes frame = new LottoMadnes();
                break;
            default:
                System.out.println("The input" + choice + "is not valid.");
        }
    }

    public static void section16(Scanner myObj) {
        // Create complex UI
        System.out.println("section 16: Create complex UI.");

        System.out.println("Enter your choice(0-3), 0 for stop:\n" + "1.\t Email editor UI. \n"
                + "2.\t Color change UI.\n" + "3.\t Tool UI.");
        int choice = myObj.nextInt();
        System.out.println("Input: " + choice);

        switch (choice) {
            case 0:
                break;
            case 1:
                WriteMail email = new WriteMail();
                break;
            case 2:
                ColorSlider frame = new ColorSlider();
                break;
            case 3:
                Tool toolframe = new Tool();
                break;
            default:
                System.out.println("The input" + choice + "is not valid.");
        }
    }

    public static void section18() {
        // Exception handling.
        System.out.println("section 18: Exception handling.");
        HomePage[] catalog = new HomePage[5];
        try {
            catalog[0] = new HomePage("Mark Evanier", "http://www.newfromme.com", "comic books");
            catalog[1] = new HomePage("Todd Smith", "http://www.sharkbitten.com", "music");
            catalog[2] = new HomePage("Rogers Cadenhead", "http://www.Cadenhead.org/workbench", "programming");
            catalog[3] = new HomePage("Mark Evanier", "http://www.baidu1.com", "comic books");
            catalog[4] = new HomePage("Mark Evanier", "https://www.google1.com", "comic books");

            for (int i = 0; i < catalog.length; i++) {
                System.out.println(catalog[i].owner + ":" + catalog[i].address + ":" + catalog[i].category);
            }
        } catch (MalformedURLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void section19() {
        System.out.println("section 19: Multi-Threading program.");
        FindPrimes fp = new FindPrimes();
    }

    public static void section20(Scanner myObj) {
        System.out.println("section 20: File IO.");
        System.out.println("Enter your choice(0-3), 0 for stop:\n" + "1.\t MP3 input. \n" + "2.\t System in.\n"
                + "3.\t Load file property.\n" + "4.\t Convert HTML file's Tag (U->L or L-U).\n");
        int choice = myObj.nextInt();
        System.out.println("Input: " + choice);

        switch (choice) {
            case 0:
                break;
            case 1:
                mp3reader("img/file_example_MP3_700KB.mp3");
                break;
            case 2:
                readConsole();
                break;
            case 3:
                loadPt("CleanTag.properties");
                break;
            case 4: 
                TagCleaner cleanner = new TagCleaner("CleanTagtest.html");
                break;

            default:
                System.out.println("The input" + choice + "is not valid.");
        }
    }

    public static void loadPt(String fileName) {
        try {
            FileInputStream configF = new FileInputStream(new File(fileName));
            Properties config = new Properties();
            config.load(configF);

            String username = config.getProperty("case");
            System.out.println("case:" + username);
        } catch (Exception err) {
            System.out.print("Error: " + err.toString());
        }

    }

    public static void mp3reader(String fileName) {
        try {
            File song = new File(fileName);
            FileInputStream file = new FileInputStream(song);
            int size = (int) song.length();
            file.skip(size - 128);
            byte[] last128 = new byte[128];
            file.read(last128);
            String id3 = new String(last128);
            String tag = id3.substring(0, 3);
            if (tag.equals("TAG")) {
                System.out.println("Title:" + id3.substring(3, 32) + "\n" + "Artist:" + id3.substring(33, 62) + "\n"
                        + "Album:" + id3.substring(63, 91) + "\n" + "Year:" + id3.substring(93, 97));
            } else {
                System.out.println("File" + fileName + "doesn't contain ID3 inforamtion.");
            }
            file.close();
        } catch (Exception err) {
            System.out.print("Error: " + err.toString());
        }
    }

    public static void readConsole() {
        StringBuffer response = new StringBuffer();
        try {
            BufferedInputStream bin = new BufferedInputStream(System.in);
            int in = 0;
            char inChar;
            do {
                in = bin.read();
                inChar = (char) in;
                if (in != -1)
                    response.append(in);
                System.out.println(">>");
            } while ((in != -1) & (inChar != '\n'));
            bin.close();
            System.out.print(">" + bin);
            return;
        } catch (Exception err) {
            System.out.print("Error: " + err.toString());
            return;
        }
    }
}
import java.util.*; // Import the Scanner class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
//-----------------------------------------------------------------------------
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

    public Point3D(int x, int y, int z){
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
class ClockFrm extends JFrame{
    public ClockFrm(){
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

class KeyView extends JFrame implements KeyListener{
    JTextField keyTxt = new JTextField(80);
    JLabel keyLb = new JLabel("Press any key in the text field.");

    KeyView(){
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

    public void keyTyped(KeyEvent input){
        char key = input.getKeyChar();
        keyLb.setText("You pressed: " + key);
    }

    public void keyPressed(KeyEvent input){

    }

    public void keyReleased(KeyEvent input){

    }
}

// -----------------------------------------------------------------------------
class B24hours {
    public static void main(String[] args) {
        int choice = 1;
        Scanner myObj = new Scanner(System.in);
        while (choice > 0) {
            System.out.println("Enter your choice(0-14), 0 for stop:");
            choice = myObj.nextInt();
            System.out.println("Input: " + choice);

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
                    section13();
                    break;
                case 14:
                    section14();
                    break;
                case 15:
                    section15();
                    break;
                default:
                    System.out.println("The input" + choice + "is not valid.");
            }
        }
    }

    public static void section1() {
        System.out.println(" 0:\tTerminate program. \n" 
                    + "1:\tShow the input list. \n" 
                    + "5:\tParameter define. \n"
                    + "6:\tString and characters.\n" 
                    + "7:\tProgram control flow.\n" 
                    + "8:\tLooping.\n"
                    + "9:\tArray and list.\n" 
                    + "10:\tObject oriented programming.\n" 
                    + "11.\tDescription object.\n"
                    + "12.\tVector test.\n"
                    + "13.\tApplication GUI.\n"
                    + "14.\tApplication layout.\n"
                    + "15.\tUI user input listener.\n"
                    );
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

    public static void section13(){
        System.out.println("section 13: Application GUI.");
        PlaybackFm pb = new PlaybackFm();
        ClockFrm clkFm = new ClockFrm();
    }

    public static void section14(){
        System.out.println("section 14: Application layout.");
        LottoMadnes frame = new LottoMadnes();
    }

    public static void section15(){
        System.out.println("section 15: UI user input listener.");
        KeyView kv = new KeyView();
    }
}
import java.util.*;  // Import the Scanner class

//-----------------------------------------------------------------------------
class Modem {
    int speed;

    public void displaySpd() {
        System.out.println("Speed: " + speed);
    }
}

class CableModen extends Modem{
    String method = "cable connection";
    public void connect(){
        System.out.println("Connecting to the internet with " +method+".");
    }
}

class DlsModen extends Modem{
    String method = "PLS phone connection";
    public void connect(){
        System.out.println("Connecting to the internet with " +method+".");
    }
}

//-----------------------------------------------------------------------------
class B24hours {
    public static void main(String[] args) {
        int choice = 1;
        Scanner myObj = new Scanner(System.in);
        while (choice > 0) {
            System.out.println("Enter your choice(0-10), 0 for stop:");
            choice = myObj.nextInt();
            System.out.println("Input: " + choice);
            
            switch(choice){
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
                default:
                    System.out.println("The input" +choice+ "is not valid.");
            }
        }
    }

    public static void section1(){
        System.out.println(" 0: Terminate program. \n"
        + "1:\tShow the input list. \n"
        + "5:\tParameter define. \n"
        + "6:\tString and characters.\n"
        + "7:\tProgram control flow.\n"
        + "8:\tLooping.\n"
        + "9:\tArray and list."
        + "10:\tObject oriented programming."
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

    public static void section8(){
        System.out.println("section 8: Looping.");
        int count = 10;
        Calendar start = Calendar.getInstance();
        int startMin = start.get(Calendar.MINUTE);
        int startSec = start.get(Calendar.SECOND);

        start.roll(Calendar.MINUTE, true);

        int nextMin = start.get(Calendar.MINUTE);
        int nextSec = start.get(Calendar.SECOND);
        while(count < 1000000){
            GregorianCalendar now = new GregorianCalendar();
            if(now.get(Calendar.MINUTE)>= nextMin && now.get(Calendar.SECOND)>=nextSec) break;
            count ++;
        }
        System.out.println("The counter added "+ count + "times");
    }

    public static void section9(){
        System.out.println("section 9: Array and list.");
        String str = "This is a String";
        char[] charList = str.toCharArray();
        for(int i =0; i<charList.length; i++){
            charList[i] = (charList[i] == ' ')? '.':charList[i];
        }
        Arrays.sort(charList);
        System.out.println("New String:" + new String(charList));
    }

    public static void section10(){
        System.out.println("section 10: Object oriented programming.");
        String count = "25";
        int myCount = Integer.parseInt(count);
        System.out.println("The square root of 25 is " + Math.sqrt(myCount));

        CableModen cm = new CableModen();
        DlsModen dm = new DlsModen();
        cm.speed = 50000;
        dm.speed = 40000;
        cm.connect();
        cm.displaySpd();
        dm.connect();
        dm.displaySpd();
    }

}
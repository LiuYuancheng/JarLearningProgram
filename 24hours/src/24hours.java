// Your First Program
import java.util.*;  // Import the Scanner class

class B24hours {
    public static void main(String[] args) {
        int choice = 1;
        Scanner myObj = new Scanner(System.in);
        while (choice > 0) {
            System.out.println("Enter your choice(0-7), 0 for stop:");
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
                default:
                    System.out.println("The input" +choice+ "is not valid.");

            }
        }
    }

    public static void section1(){
        System.out.println(" 0: Terminate program. \n"
        + "1: Show the input list. \n"
        + "5: Parameter define."
        + "6: String and characters."
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
}
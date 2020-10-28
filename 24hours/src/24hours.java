// Your First Program
import java.util.Scanner;  // Import the Scanner class

class B24hours {
    public static void main(String[] args) {
        System.out.println("Enter your choice(0-5), 0 for stop:");
        Scanner myObj = new Scanner(System.in);

        int choice = myObj.nextInt();

        System.out.println("Input: " + choice);
        section5();

    }

    public static void section1(){
        System.out.println(" 0: Terminate program. \n"
        + "1: Show the input list. \n"
        + "5: Parameter define"
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
}
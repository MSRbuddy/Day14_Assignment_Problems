import java.util.*;

public class GamblingSimulation
{
    public static void main(String[] args)
    {
        Utility1 u=new Utility1();
        System.out.println("Enter $Stake value: ");
        int $Stake=u.inputInteger();
        System.out.println("Enter $Goal value: ");
        int $Goal=u.inputInteger();
        System.out.println("Enter number of times: ");
        int noOfTimes=u.inputInteger();

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        // repeat number of times
        for (int i=0; i< noOfTimes; i++)
        {
            int cash = $Stake;

            while (cash > 0 && cash < $Goal)
            {
                bets++;

                if (Math.random() < 0.5)
                    cash++;     // win $1
                else
                    cash--;     // lose $1
            }
            if (cash == $Goal)
                wins++;                // to find no. of wins
        }

        // print results
        System.out.println();
        System.out.println(wins + " wins of " + noOfTimes);
        System.out.println("Percent of games won = " + 100.0 * wins / noOfTimes);
        System.out.println("Avg # bets           = " + 1.0 * bets / noOfTimes);
    }
}

class Utility1 {

    static Scanner scanner = new Scanner(System.in);

    // To return String Input
    public static String inputString() {

        try {
            return scanner.next();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input, try again.");
            return inputString();
        }
    }


    //To return String Input Line
    public static String inputStringLine() {

        try {
            return scanner.nextLine();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input, try again.");
            return inputStringLine();
        }
    }

    //To return Long input
    public static long inputlong() {
        try {
            return scanner.nextLong();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input, try again.");
            return inputlong();
        }
    }

    //To return Integer input
    public static int inputInteger() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input, try again.");
            return inputInteger();
        }

    }

    //To return Double input
    public static double inputDouble() {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input, try again.");
            return inputDouble();
        }

    }

    //To return Boolean input;
    public static boolean inputBoolean() {
        try {
            return scanner.nextBoolean();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input, try again.");
            return inputBoolean();
        }
    }

}


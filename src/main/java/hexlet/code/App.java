package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        System.out.println("Welcome to the Brain Games!");

        switch (Integer.parseInt(input)) {
            case (0):
                System.out.println("See u later.");
                break;
            case (1):
                Cli.greeting();
                break;
            case (2):
                Even.even();
                break;
            case (3):
                Calc.calc();
                break;
            default:
                break;
        }
    }
}

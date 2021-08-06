package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        String choice = Engine.INPUT.nextLine();
        System.out.println("Welcome to the Brain Games!");

        switch (choice) {
            case ("1"):
                Engine.greeting(Engine.getName());
                break;
            case ("2"):
                Even.even();
                break;
            case ("3"):
                Calc.calc();
                break;
            case ("4"):
                GCD.gcd();
                break;
            case ("5"):
                Progression.progression();
                break;
            case ("6"):
                Prime.prime();
                break;
            case ("0"):
                break;
            default:
                throw new RuntimeException("Unexpected choice: " + choice);
        }
    }
}

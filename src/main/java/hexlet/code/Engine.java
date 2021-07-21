package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {
    public static final int ROUNDS = 3;
    private static final int START_BOUND = 1;
    public static final int END_BOUND = 100;

    public static boolean interact(String question, String correct) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        if (answer.equals(correct)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correct);
            System.out.printf("Let's try again, %s!%n", Cli.getName());
            return false;
        }
        return true;
    }

    public static int randomNum(int bound) {
        return ThreadLocalRandom.current().nextInt(START_BOUND, bound);
    }
}

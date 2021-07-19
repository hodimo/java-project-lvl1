package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {
    public final static int ROUNDS = 3;
    private static String answer;
    private static int successfulRound = 0;

    public static void interaction(String question, String correct) {
        System.out.println("Question: " + question);
        setAnswer();
        if (getAnswer().equals(correct)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correct);
            System.out.printf("Let's try again, %s!%n", Cli.getName());
            successfulRound = 0;
            System.exit(0);
        }
    }

    public static int randomNum(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    private static void setAnswer() {
        System.out.print("Your answer: ");
        Scanner in = new Scanner(System.in);
        answer = in.nextLine();
    }

    public static String getAnswer() {
        return answer;
    }

    public static void showIfDone() {
        if (successfulRound < ROUNDS - 1) {
            successfulRound++;
        } else {
            System.out.printf("Congratulations, %s!%n", Cli.getName());
            successfulRound = 0;
        }
    }
}

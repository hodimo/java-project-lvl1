package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static final Scanner INPUT = new Scanner(System.in);

    public static void interact(String[][] sentences, String gameDescription) {
        String name = getName();
        greeting(name);
        System.out.println(gameDescription);

        for (int i = 0; i < ROUNDS; i++) {
            String question = sentences[i][0];
            String correct = sentences[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = INPUT.nextLine();
            if (answer.equals(correct)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correct);
                System.out.printf("Let's try again, %s!%n", name);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", name);
    }

    public static String getName() {
        System.out.print("May I have your name? ");
        return INPUT.nextLine();
    }

    public static void greeting(String name) {
        System.out.printf("Hello, %s!%n", name);
    }
}

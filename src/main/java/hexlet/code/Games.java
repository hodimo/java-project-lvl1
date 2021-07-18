package hexlet.code;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Games {
    static void even() {
        Cli.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            int num = ThreadLocalRandom.current().nextInt();
            String correct = num % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + num);
            System.out.println("Your answer: ");
            Scanner in = new Scanner(System.in);
            String answer = in.nextLine();
            if (correct.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correct);
                System.out.printf("Let's try again, %s!%n", Cli.getName());
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", Cli.getName());
    }
}

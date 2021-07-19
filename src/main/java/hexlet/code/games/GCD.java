package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.ArrayList;

public class GCD {
    public static void gcd() {
        Cli.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < Engine.ROUNDS; i++) {
            final int num1 = Engine.randomNum(100);
            final int num2 = Engine.randomNum(100);
            final String question = String.format("%d %d", num1, num2);
            final String correct = String.format("%d", findGCD(num1, num2));
            Engine.interaction(question, correct);
            Engine.showIfDone();
        }

    }

    private static int findGCD(int num1, int num2) {
        ArrayList<Integer> dividers1 = findDividers(num1);
        ArrayList<Integer> dividers2 = findDividers(num2);
        for (int i = 0; i < dividers1.size(); i++) {
            if (dividers2.contains(dividers1.get(i))) {
                dividers2.remove(dividers1.get(i));
            } else {
                dividers1.set(i, 1);
            }
        }
        return dividers1.stream().mapToInt(n -> n)
                .reduce(1, (result, n) -> result * n);
    }

    private static ArrayList<Integer> findDividers(int num) {
        ArrayList<Integer> dividers = new ArrayList<>();
        int n = num;
        int divider = 2;
        while (n / divider >= 1) {
            if (n % divider == 0) {
                n = n / divider;
                dividers.add(divider);
            } else if (divider == 2) {
                divider++;
            } else {
                divider += 2;
            }
        }
        return dividers;
    }
}
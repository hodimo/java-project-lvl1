package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import java.util.ArrayList;
import java.util.Arrays;

public class Progression {
    private static final int DEFAULT_LENGTH = 4;
    private static final int LENGTH_BOUND = 7;
    private static final int DIFF_BOUND = 10;

    public static void progression() {
        Cli.greeting();
        System.out.println("What number is missing in the progression?");
        for (int i = 0; i < Engine.ROUNDS; i++) {
            ArrayList<Integer> progression = generateProgression();
            int unknown = progression.get(Engine.randomNum(progression.size()));
            String question = Arrays.toString(progression.toArray())
                    .replaceAll("[\\[\\],g]", "")
                    .replaceFirst("(" + unknown + ")", "..");
            String correct = Integer.toString(unknown);
            Engine.interaction(question, correct);
            Engine.showIfDone();
        }
    }

    private static ArrayList<Integer> generateProgression() {
        int length = generateLength();
        int initNum = Engine.randomNum(Engine.END_BOUND);
        int difference = Engine.randomNum(DIFF_BOUND);
        ArrayList<Integer> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(initNum);
            initNum += difference;
        }
        return progression;
    }

    private static int generateLength() {
        return DEFAULT_LENGTH + Engine.randomNum(LENGTH_BOUND);
    }
}

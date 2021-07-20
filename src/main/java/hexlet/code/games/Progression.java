package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;

public class Progression {
    private static final int DEFAULT_LENGTH = 5;
    private static int initNum = Engine.randomNum(10);

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
        int difference = Engine.randomNum(10);
        ArrayList<Integer> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(initNum);
            initNum += difference;
        }
        return progression;
    }

    private static int generateLength() {
        return DEFAULT_LENGTH + Engine.randomNum(6);
    }
}

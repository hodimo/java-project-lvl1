package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Progression {
    private static final int DEFAULT_LENGTH = 5;
    private static final int LENGTH_BOUND = 6;
    private static final int DEFAULT_DIFF = 1;
    private static final int DIFF_BOUND = 9;
    private static final int INIT_BOUND = 100;

    public static void progression() {
        Engine.interact(generateSentences(),
                "What number is missing in the progression?");
    }

    private static String[][] generateSentences() {
        String[][] sentences = new String[Engine.ROUNDS][2];
        for (int i = 0; i < sentences.length; i++) {
            ArrayList<Integer> progression = generateProgression();
            int unknown = progression.get(Utils.random(progression.size()));
            String question = Arrays.toString(progression.toArray())
                    .replaceAll("[\\[\\],g]", "")
                    .replaceFirst("(" + unknown + ")", "..");
            String correct = Integer.toString(unknown);
            sentences[i][0] = question;
            sentences[i][1] = correct;
        }
        return sentences;
    }

    private static ArrayList<Integer> generateProgression() {
        int length = generateLength();
        int initNum = Utils.random(INIT_BOUND);
        int difference = DEFAULT_DIFF + Utils.random(DIFF_BOUND);
        ArrayList<Integer> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(initNum);
            initNum += difference;
        }
        return progression;
    }

    private static int generateLength() {
        return DEFAULT_LENGTH + Utils.random(LENGTH_BOUND);
    }
}

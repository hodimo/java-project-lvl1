package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int random(int boundExclusive) {
        return RANDOM.nextInt(boundExclusive);
    }

    public static int random(int startInclusive, int endExclusive) {
        return startInclusive + RANDOM.nextInt(endExclusive) * 2;
    }
}

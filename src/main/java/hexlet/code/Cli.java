package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String name;

    static String getName() {
        return name;
    }

    public static void greeting() {
        System.out.print("May I have your name? ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        System.out.printf("Hello, %s!\n", name);
    }
}

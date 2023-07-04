package util;

import java.util.Scanner;

public class ScannerInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static String nextLine() {
        return scanner.nextLine();
    }
}
package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dame la longitud del sendero: ");
        final int length = scanner.nextInt();

        // Otras características del sendero.
        final char[] trailElements = { ' ', ' ', ' ', ' ', '$', '*' };
        final int width = 4;
        final int shift = 1;

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int lastPadding = 0;

        for (int i = 0; i < length; i++) {
            lastPadding = getPadding(lastPadding, shift, random);
            System.out.print(" ".repeat(lastPadding));

            System.out.print(getTrail(width, trailElements, stringBuilder, random));

            System.out.println();
        }
    }
    public static String getTrail (int width, char[] trailElements, StringBuilder stringBuilder, Random random) {
        if (width < 3) {
            throw new IllegalArgumentException("`width` can't be lower than 3.");
        }

        // Limpia el buffer
        stringBuilder.setLength(0);

        stringBuilder.append('|');

        for (int i = 0; i < width - 2; i++) {
            int randomPosition = random.nextInt(trailElements.length);
            stringBuilder.append(trailElements[randomPosition]);
        }

        stringBuilder.append('|');
        return stringBuilder.toString();
    }
    public static int getPadding (int lastPadding, int shift, Random random) throws IllegalArgumentException {
        if (lastPadding < 0) {
            throw new IllegalArgumentException("`lastPadding can't be negative.`");
        }

        int[] options;

        if (lastPadding == 0) {
            options = new int[] {lastPadding, lastPadding + shift};
        } else {
            options = new int[] {lastPadding, lastPadding + shift, lastPadding - shift};
        }

        return options[random.nextInt(options.length)];
    }
}

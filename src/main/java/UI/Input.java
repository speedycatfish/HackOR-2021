package UI;

import rhythm.Rhythm;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("What note precision would you like to round to (1/4, 1/8, 1/6, etc). Please enter a decimal number between 0 and 1");

        String notePrecisionStr = in.nextLine();

        double notePrecision = Double.parseDouble(notePrecisionStr);

        Rhythm rhythm = new Rhythm(notePrecision);


    }
}

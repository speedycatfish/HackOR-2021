package UI;

import rhythm.Rhythm;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {

        Rhythm rhythm = new Rhythm();

        Scanner in = new Scanner(System.in);

        System.out.println("What note precision would you like to round to (1/4, 1/8, 1/6, etc). Please enter a decimal number between 0 and 1");
        String notePrecisionStr = in.nextLine();
        double notePrecision = Double.parseDouble(notePrecisionStr);

        System.out.println("What time signature is the piece in? Please specify with a fraction such as 3/4 or 4/4");
        String timeSignature = in.nextLine();

        System.out.println("Press s when you are ready to begin recording measure times and press e when you are done!");

        String startMeasures = in.nextLine();
        rhythm.startMeasures();

        while (!in.nextLine().equals("e")) {
            rhythm.addMeasure();
        }

        System.out.println("Press s when you are ready to begin recording note times and press e when you are done!");

        String startNotes = in.nextLine();
        rhythm.startNotes();

        while (!in.nextLine().equals("e")) {
            rhythm.addNote();
        }

        rhythm.roundNotes();

    }
}

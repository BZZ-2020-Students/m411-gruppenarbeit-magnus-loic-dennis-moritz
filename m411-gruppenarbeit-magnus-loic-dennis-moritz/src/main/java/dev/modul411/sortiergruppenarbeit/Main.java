package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importfile.ReadFile;

/**
 * Main Class
 *
 * @author Dennis Woodtli, Loic Flückiger, Magnus Götz, Moritz Gasbichler
 * @version 1.0
 * @since 2022-01-04
 */
public class Main {
    private final String pathPrefix = "src/main/resources/importfiels/";

    public Main() {
        getImputs();
    }

    public void getImputs() {
        ReadFile readFile = new ReadFile();
        int[] tenDigits;
        int[] hundredDigits;
        int[] thousandDigits;

        tenDigits = readFile.readLinesFromFile(pathPrefix + "10Digits.dat");
        System.out.println("The Digits of the 10 Digits File: ");
        printDigits(tenDigits);

        hundredDigits = readFile.readLinesFromFile(pathPrefix + "100Digits.dat");
        System.out.println("The Digits of the 100 Digits File: ");
        printDigits(hundredDigits);

        thousandDigits = readFile.readLinesFromFile(pathPrefix + "1000Digits.dat");
        System.out.println("The Digits of the 1000 Digits File: ");
        printDigits(thousandDigits);
    }

    private void printDigits(int[] digits) {
        for (int i : digits) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

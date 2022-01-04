package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importfile.ReadFile;

/**
 * Main Class
 *
 * @author Magnus Götz, Moritz Gasbichler
 * @version 1.0
 * @since 2022-01-04
 */
public class Main {
    private final String pathPrefix = "src/main/resources/importfiels/";
    private int[] tenDigits;
    private int[] hundredDigits;
    private int[] thousandDigits;

    public Main() {
        ReadFile readFile = new ReadFile();
        tenDigits = readFile.readLinesFromFile(pathPrefix + "10Digits.dat");
        hundredDigits = readFile.readLinesFromFile(pathPrefix + "100Digits.dat");
        thousandDigits = readFile.readLinesFromFile(pathPrefix + "1000Digits.dat");
    }

    public void compareSortingAlgorithm() {
        //TODO sort and messaure the files using the three arrays read from the files
    }


    public static void main(String[] args) {
        Main main = new Main();
    }
}

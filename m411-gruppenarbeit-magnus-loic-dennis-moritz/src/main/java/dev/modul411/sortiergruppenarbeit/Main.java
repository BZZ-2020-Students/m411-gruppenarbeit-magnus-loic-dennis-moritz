package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importexport.ExportFile;
import dev.modul411.sortiergruppenarbeit.importexport.ImportFile;

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
        ImportFile importFile = new ImportFile();
        tenDigits = importFile.readLinesFromFile(pathPrefix + "10Digits.dat");
        hundredDigits = importFile.readLinesFromFile(pathPrefix + "100Digits.dat");
        thousandDigits = importFile.readLinesFromFile(pathPrefix + "1000Digits.dat");

        ExportFile exportFile = new ExportFile();
        
    }

    public void compareSortingAlgorithm() {
        //TODO sort the values using the three arrays read from the files
    }


    public static void main(String[] args) {
        Main main = new Main();
    }
}

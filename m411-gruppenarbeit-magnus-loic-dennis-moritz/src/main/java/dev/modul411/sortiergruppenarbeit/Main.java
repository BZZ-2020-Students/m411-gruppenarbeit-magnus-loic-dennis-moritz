package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importexport.ExportFile;
import dev.modul411.sortiergruppenarbeit.importexport.ImportFile;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Bubblesort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Mergesort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Quicksort;

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
        compareSortingAlgorithm();
        ExportFile exportFile = new ExportFile("exportFile.csv", new String[]{"Bubblesort", "5GB", "100000", "5s"},new String[]{"Mergesort", "10MB", "120000", "5ms"},new String[]{"Quicksort", "10Byte", "50000", "2ms"});
        exportFile.writeInCsvFile();

    }

    public void compareSortingAlgorithm() {
        //TODO sort the values using the three arrays read from the files
        int[] sr = {432324, 234234, 235, 32523, 534, 64533, 6, 3256, 3476, 5346356, 4235, 6, 23, 324, 234, 343,324,32423424,32423423,3432,4351,3613455,145,4636154,63164356,17438547,874563456,32423,3122315};
        Bubblesort b = new Bubblesort();
        Mergesort m = new Mergesort();
        Quicksort q = new Quicksort();
//        long[] arr = b.run(s);
        long[] arr2 = m.run(sr);
//        long[] arr3 = q.run(s);

        System.out.println(arr2[0]);
    }


    public static void main(String[] args) {
        new Main();
    }
}

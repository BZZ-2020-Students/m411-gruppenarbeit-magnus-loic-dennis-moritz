package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importexport.ExportFile;
import dev.modul411.sortiergruppenarbeit.importexport.ImportFile;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Bubblesort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Mergesort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Quicksort;

import java.util.ArrayList;

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
//        ImportFile importFile = new ImportFile();
//        tenDigits = importFile.readLinesFromFile(pathPrefix + "10Digits.dat");
//        hundredDigits = importFile.readLinesFromFile(pathPrefix + "100Digits.dat");
//        thousandDigits = importFile.readLinesFromFile(pathPrefix + "1000Digits.dat");
        compareSortingAlgorithm();
        ArrayList<String[]> values = new ArrayList<>();
        values.add(new String[]{"Bubblesort", "10", "5GB", "1000", "5s"});
        values.add(new String[]{"Bubblesort", "100", "15GB", "10000", "15s"});
        values.add(new String[]{"Bubblesort", "1000", "150GB", "100000", "150s"});
        values.add(new String[]{"Mergesort", "10", "5MB", "750", "1s"});
        values.add(new String[]{"Mergesort", "100", "15MB", "800", "4s"});
        values.add(new String[]{"Mergesort", "1000", "150MB", "850", "7s"});
        values.add(new String[]{"Quicksort", "10", "5Byte", "250", "0.5s"});
        values.add(new String[]{"Quicksort", "100", "15Byte", "350", "2s"});
        values.add(new String[]{"Quicksort", "1000", "150Byte", "500", "3s"});

        ExportFile exportFile = new ExportFile("exportFile.csv", values);
        exportFile.writeInCsvFile();

    }

    public void compareSortingAlgorithm() {
        //TODO sort the values using the three arrays read from the files
        int[] sr = {432324, 234234, 235, 32523, 534, 64533, 6, 3256, 3476, 5346356, 4235, 6, 23, 324, 234, 343,324,32423424,32423423,3432,4351,3613455,145,4636154,63164356,17438547,874563456,32423,3122315};
        int[] sr1 = {432324, 234234, 235, 32523, 534, 64533, 6, 3256, 3476, 5346356, 4235, 6, 23, 324, 234, 343,324,32423424,32423423,3432,4351,3613455,145,4636154,63164356,17438547,874563456,32423,3122315};
        int[] sr2 = {432324, 234234, 235, 32523, 534, 64533, 6, 3256, 3476, 5346356, 4235, 6, 23, 324, 234, 343,324,32423424,32423423,3432,4351,3613455,145,4636154,63164356,17438547,874563456,32423,3122315};

        Bubblesort b = new Bubblesort();
        Mergesort m = new Mergesort();
        Quicksort q = new Quicksort();
        long[] arr = b.run(sr);
        long[] arr2 = m.run(sr1);
        long[] arr3 = q.run(sr2);

    }


    public static void main(String[] args) {
        new Main();
    }
}

package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importexport.ExportFile;
import dev.modul411.sortiergruppenarbeit.importexport.ImportFile;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Bubblesort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Mergesort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Quicksort;
import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Sorter;

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
    private ArrayList<int[]> digitArrays = new ArrayList<>();
    private ArrayList<Sorter> sortingAlgorithm = new ArrayList<>();

    public Main() {
        ImportFile importFile = new ImportFile();
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "10Digits.dat"));
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "100Digits.dat"));
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "1000Digits.dat"));
        sortingAlgorithm.add(new Bubblesort());
        sortingAlgorithm.add(new Mergesort());
        sortingAlgorithm.add(new Quicksort());
        System.out.println(importFile.readLinesFromFile(pathPrefix + "10Digits.dat").length);
        System.out.println(importFile.readLinesFromFile(pathPrefix + "100Digits.dat").length);
        System.out.println(importFile.readLinesFromFile(pathPrefix + "1000Digits.dat").length);

//        ArrayList<String[]> values = new ArrayList<>();
//        values.add(new String[]{"Bubblesort", "10", "5GB", "1000", "5s"});
//        values.add(new String[]{"Bubblesort", "100", "15GB", "10000", "15s"});
//        values.add(new String[]{"Bubblesort", "1000", "150GB", "100000", "150s"});
//        values.add(new String[]{"Mergesort", "10", "5MB", "750", "1s"});
//        values.add(new String[]{"Mergesort", "100", "15MB", "800", "4s"});
//        values.add(new String[]{"Mergesort", "1000", "150MB", "850", "7s"});
//        values.add(new String[]{"Quicksort", "10", "5Byte", "250", "0.5s"});
//        values.add(new String[]{"Quicksort", "100", "15Byte", "350", "2s"});
//        values.add(new String[]{"Quicksort", "1000", "150Byte", "500", "3s"});
//
        ExportFile exportFile = new ExportFile("exportFile.csv", compareSortingAlgorithm());
        exportFile.writeInCsvFile();

    }

    public ArrayList<String[]> compareSortingAlgorithm() {
        ArrayList<String[]> values = new ArrayList<>();
        for (int[] da : digitArrays) {
            for (Sorter s : sortingAlgorithm) {
                Measure measure = new Measure();
                values.add(new String[]{s.getAlgorithmName() + " - " + (da.length + 1), String.valueOf(measure.getMemory()), String.valueOf(measure.getComparison()), String.valueOf(measure.getComparison())});
            }
        }
        return values;
    }


    public static void main(String[] args) {
        new Main();
    }
}

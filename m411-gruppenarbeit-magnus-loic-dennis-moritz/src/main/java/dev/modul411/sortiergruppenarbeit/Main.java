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

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "10Digits.dat"));
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "100Digits.dat"));
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "1000Digits.dat"));
        sortingAlgorithm.add(new Bubblesort());
        sortingAlgorithm.add(new Mergesort());
        sortingAlgorithm.add(new Quicksort());
        ExportFile exportFile = new ExportFile("exportFile.csv", compareSortingAlgorithm());
        exportFile.writeInCsvFile();

    }

    public ArrayList<String[]> compareSortingAlgorithm() {
        Measure measure = new Measure();
        Sort sort = new Sort();
        ArrayList<String[]> values = new ArrayList<>();
        for (int[] valuesToSort : digitArrays) {
            for (Sorter algorithmtoSort : sortingAlgorithm) {
                sort.sort(algorithmtoSort, valuesToSort, measure);
                values.add(new String[]{algorithmtoSort.getAlgorithmName() + " - " + (valuesToSort.length + 1), String.valueOf(measure.getMemory()), String.valueOf(measure.getComparison()), String.valueOf(measure.getTime() / 1_000_000f)});
            }
        }
        return values;
    }


    public static void main(String[] args) {
        new Main();
    }
}

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

    /**
     * Default constructor handles import & sorting and export
     */
    public Main() {
        ImportFile importFile = new ImportFile();
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "10Digits.dat"));
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "100Digits.dat"));
        digitArrays.add(importFile.readLinesFromFile(pathPrefix + "1000Digits.dat"));
        sortingAlgorithm.add(new Bubblesort());
        sortingAlgorithm.add(new Mergesort());
        sortingAlgorithm.add(new Quicksort());
        ExportFile exportFile = new ExportFile("exportFile.csv", compareSortingAlgorithm());
        exportFile.writeInCsvFile();

    }

    /**
     * This method handles the sorting of the three arrays for the three algorithms
     *
     * @return an ArrayList with all values from the algorithms ready to write them to the csv file
     */
    public ArrayList<String[]> compareSortingAlgorithm() {

        ArrayList<String[]> values = new ArrayList<>();
        for (int[] valuesToSort : digitArrays) {
            for (Sorter algorithmtoSort : sortingAlgorithm) {
                Measure measure = new Measure();
                Sort sort = new Sort();
                sort.sort(algorithmtoSort, valuesToSort, measure);
                values.add(new String[]{algorithmtoSort.getAlgorithmName() + " - " + valuesToSort.length, String.valueOf(measure.getMemory()), String.valueOf(measure.getComparison()), String.valueOf(measure.getTime() / 1_000_000f)});
            }
        }
        return values;
    }

    public static void main(String[] args) {
        new Main();
    }
}

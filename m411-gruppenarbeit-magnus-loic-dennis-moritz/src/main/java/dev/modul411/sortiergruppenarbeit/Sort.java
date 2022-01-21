package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Sorter;

/**
 * Sort class manage the Measurements with wich Sorter
 *
 * @Author Magnus Götz
 * @Since 2022-01-04
 * @Version 1.0
 */

public class Sort<T extends Sorter> {
    /**
     * Handles the Measurements with which Sorter
     *
     * @param sorter        with which sorter is sorted
     * @param unsortedArray the array which will be sorted
     * @param measure       to measure the different information about the mergesort
     */
    public void sort(T sorter, int[] unsortedArray, Measure measure) {
        //Measure time
        long startTime = System.nanoTime();

        //Sort
        sorter.sort(unsortedArray, measure);

        //End time
        measure.setTime(System.nanoTime() - startTime);
    }
}

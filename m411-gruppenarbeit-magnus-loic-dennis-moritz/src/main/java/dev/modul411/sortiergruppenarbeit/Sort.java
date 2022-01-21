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
     * Handels the Measurements with wich Sorter
     *
     * @param sorter        with which sorter is sorted
     * @param unsortedArray the array which will be sorted
     * @param measure       to measure the different informations about the mergeosrt
     */
    public void sort(T sorter, int[] unsortedArray, Measure measure) {

        //Measure memory
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //Measure time
        long startTime = System.nanoTime();

        //Sort
        sorter.sort(unsortedArray, measure);

        //End time
        measure.setTime(System.nanoTime() - startTime);

        //End memory
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        measure.setMemory(usedMemoryAfter - usedMemoryBefore);
    }
}

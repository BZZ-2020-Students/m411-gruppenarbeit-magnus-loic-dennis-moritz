package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.sortingalgorithm.Sorter;

public class Sort<T extends Sorter> {
    public void sort(T sorter, int[] unsortedArray, Measure measure){

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

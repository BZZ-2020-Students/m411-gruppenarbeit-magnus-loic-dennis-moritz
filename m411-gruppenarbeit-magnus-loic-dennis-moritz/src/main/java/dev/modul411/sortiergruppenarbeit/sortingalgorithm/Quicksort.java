package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Timer;

/**
 * @Author Magnus Götz
 * @Since 2022-01-04
 * @Version 1.0
 */

public class Quicksort {

    private int[] unsortedArray;
    private int count = 0;

    public Quicksort() {
    }

    public long[] run(int[] unsortedArray) {
        long[] measure = new long[3];
        this.unsortedArray = unsortedArray;
        //Measure memory
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //Measure time
        Instant startTimeInstant = Instant.now().truncatedTo(ChronoUnit.MICROS);
        long startTime = startTimeInstant.getNano() / 1000;

        //sort
        sort(0, unsortedArray.length - 1);

        //End time
        Instant endTimeInstant = Instant.now().truncatedTo(ChronoUnit.MICROS);
        long endTime = endTimeInstant.getNano() / 1000;
        System.out.println("Dauer der Sortierung: " + (endTime - startTime) + " mikrosekunden");
        measure[0] = endTime - startTime;

        //End memory
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) + " byte");
        measure[1] = usedMemoryAfter - usedMemoryBefore;

        //Measure comparisons
        System.out.println("How many comparisons: " + count);
        measure[2] = count;
        return measure;
    }

    private void sort(int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int middlePos = split(leftPos, rightPos);
            sort(leftPos, middlePos - 1);
            sort(middlePos + 1, rightPos);
        }
    }

    public Quicksort(int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int middlePos = split(leftPos, rightPos);
            new Quicksort(leftPos, middlePos - 1);
            new Quicksort(middlePos + 1, rightPos);
        }
    }

    public int split(int leftPos, int rightPos) {
        int pivotPos = leftPos;
        while (leftPos < rightPos) {
            count++;
            if (unsortedArray[rightPos] > unsortedArray[pivotPos]) {
                rightPos--;
            } else {
                if (unsortedArray[leftPos] <= unsortedArray[pivotPos])
                    leftPos++;
                else
                    swap(leftPos, rightPos);
            }
        }
        swap(pivotPos, rightPos);
        return rightPos;
    }

    public void swap(int leftPos, int rightPos) {
        int temp = unsortedArray[rightPos];
        unsortedArray[rightPos] = unsortedArray[leftPos];
        unsortedArray[leftPos] = temp;
    }
}

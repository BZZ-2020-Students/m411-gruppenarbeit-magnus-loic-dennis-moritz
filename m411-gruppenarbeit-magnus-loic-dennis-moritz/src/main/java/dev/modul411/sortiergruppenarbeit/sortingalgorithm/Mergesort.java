package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * @Author Magnus Götz
 * @Since 2022-01-04
 * @Version 1.0
 */


public class Mergesort {
    private int[] unsortedArray;
    private int count = 0;

    public Mergesort() {
    }

    public long[] run(int[] unsortedArray) {
        long[] measure = new long[3];
        this.unsortedArray = unsortedArray;

        //Measure memory
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //Measure time
        Instant startTimeInstant = Instant.now().truncatedTo(ChronoUnit.NANOS);
        long startTime = startTimeInstant.getNano() / 1000;
        System.out.println(startTime);

        //sort
        int[] sortedARR = loop(unsortedArray);

        //End time
        Instant endTimeInstant = Instant.now().truncatedTo(ChronoUnit.NANOS);
        long endTime = endTimeInstant.getNano() / 1000;
        System.out.println(endTime);
        System.out.println("Dauer der Sortierung: " + (endTime - startTime) + " mikrosekunden");
        measure[0] = endTime - startTime;

        //End memory
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) + " byte");
        measure[1] = usedMemoryAfter - usedMemoryBefore;

        //Measure comparisons
        System.out.println("How many comparisons: " + count);
        measure[2] = count;


        Instant test = Instant.now().truncatedTo(ChronoUnit.MICROS);
        long testTime = test.getNano() / 1000;
        System.out.println(testTime);


        return measure;
    }

    public int[] loop(int[] unsortedArray) {
        for (int start = 0; start < unsortedArray.length; ++start) {
            count++;
            int minIndex = findTheMiniIndex(unsortedArray, start);
            swap(unsortedArray, minIndex, start);
        }
        return unsortedArray;
    }

    public int findTheMiniIndex(int[] arr, int start) {
        int index = start;
        for (int i = start + 1; i < arr.length; ++i) {
            if (arr[index] > arr[i]) {
                index = i;
            }
        }
        return index;
    }

    public void swap(int[] swapValOfArr, int minIndex, int start) {
        int temp = swapValOfArr[minIndex];
        swapValOfArr[minIndex] = swapValOfArr[start];
        swapValOfArr[start] = temp;
    }
}

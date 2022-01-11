package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Bubblesort Class
 *
 * @author Magnus Götz
 * @version 1.0
 * @since 2022-01-04
 */

public class Bubblesort {

    private int[] unsortedArray;
    private int count = 0;

    public Bubblesort() {
    }

    public long[] run(int[] unsortedArray) {
        long[] measure = new long[3];
        this.unsortedArray = unsortedArray;

        //Measure memory
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //Measure time
        Instant startTimeInstant = Instant.now().truncatedTo(ChronoUnit.MICROS);
        long startTime = startTimeInstant.getNano();

        sort();

        Instant endTimeInstant = Instant.now().truncatedTo(ChronoUnit.MICROS);
        long endTime = endTimeInstant.getNano();
        System.out.println("Dauer der Sortierung: " + (endTime - startTime) + " mikrosekunden");
        measure[0] = endTime - startTime;

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) + " byte");
        measure[1] = usedMemoryAfter - usedMemoryBefore;

        //Measure comparisons
        System.out.println("How many comparisons: " + count);
        measure[2] = count;
        return measure;
    }

    private void sort() {
        boolean finish;
        for (int a = 0; a < unsortedArray.length - 1; a++) {
            finish = true;
            for (int b = 0; b < unsortedArray.length - a - 1; b++) {
                count++;
                if (unsortedArray[b] > unsortedArray[b + 1]) {
                    int temp = unsortedArray[b];
                    unsortedArray[b] = unsortedArray[b + 1];
                    unsortedArray[b + 1] = temp;
                    finish = false;
                }
            }
            if (finish)
                break;
        }
    }
}

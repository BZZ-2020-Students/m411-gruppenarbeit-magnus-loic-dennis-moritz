package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;

/**
 * Interface for the different algorithms
 *
 * @Author Magnus Götz, Moritz Gasbichler
 * @Since 2022-01-18
 * @Version 1.0
 */

public interface Sorter {
    /**
     * @param arr     the array which will be sorted by the algorithm
     * @param measure the measure object which will be used to get information about the algorithm
     */
    void sort(int[] arr, Measure measure);

    /**
     * @return the name of the algorithm
     */
    String getAlgorithmName();
}

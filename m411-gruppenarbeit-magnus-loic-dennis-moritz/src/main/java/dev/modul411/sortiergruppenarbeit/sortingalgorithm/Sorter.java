package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;

/**
 * @Author Magnus Götz, Moritz Gasbichler
 * @Since 2022-01-18
 * @Version 1.0
 */

public interface Sorter {
    void sort(int[] arr, Measure measure);

    String getAlgorithmName();
}

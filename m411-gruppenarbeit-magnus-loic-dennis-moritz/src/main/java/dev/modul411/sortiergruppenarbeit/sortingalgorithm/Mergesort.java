package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;

/**
 * Mergesort class sorts the values using the mergesort
 *
 * @Author Magnus Götz, Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */


public class Mergesort implements Sorter {
    private int countComparison = 0;
    private int countIteration = 0;

    /**
     * Default constructor
     */
    public Mergesort() {
    }

    /**
     * Handels the sorting with the mergesort
     *
     * @param unsortedArray the array which will be sorted
     * @param measure       to measure the different information about the mergeosrt
     */
    @Override
    public void sort(int[] unsortedArray, Measure measure) {
        //sort
        int[] sortedArray = loop(unsortedArray);

        measure.setComparison(countComparison);
        measure.setIterations(countIteration);
        measure.setSortedArray(sortedArray);
    }

    /**
     * @return the name of the sort
     */
    @Override
    public String getAlgorithmName() {
        return "Mergesort";
    }

    /**
     * @param unsortedArray the array which will be sorted
     * @return the sorted array
     */
    public int[] loop(int[] unsortedArray) {
        for (int start = 0; start < unsortedArray.length; ++start) {
            countIteration++;
            int minIndex = findTheMiniIndex(unsortedArray, start);
            swap(unsortedArray, minIndex, start);
        }
        return unsortedArray;
    }

    /**
     * @param arr   the array
     * @param start position on which the algorithm should start
     * @return smallest index
     */
    public int findTheMiniIndex(int[] arr, int start) {
        int index = start;
        for (int i = start + 1; i < arr.length; ++i) {
            countComparison++;
            if (arr[index] > arr[i]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * @param swapValOfArr the array in which the values should be swapped
     * @param minIndex     the first index
     * @param start        the second index
     */
    public void swap(int[] swapValOfArr, int minIndex, int start) {
        int temp = swapValOfArr[minIndex];
        swapValOfArr[minIndex] = swapValOfArr[start];
        swapValOfArr[start] = temp;
    }
}

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
    private int count = 0;

    /**
     * Default constructor
     */
    public Mergesort() {
    }

    /**
     * Handels the sorting with the mergesort
     *
     * @param unsortedArray the array which will be sorted
     * @param measure       to measure the different informations about the mergeosrt
     */
    @Override
    public void sort(int[] unsortedArray, Measure measure) {
        //sort
        int[] sortedARR = loop(unsortedArray);

        measure.setComparison(count);
        measure.setSortedArray(sortedARR);
    }

    /**
     * @return the name of the sort
     */
    @Override
    public String getAlgorithmName() {
        return "Mergesort";
    }

    /**
     * @param unsortedArray
     * @return
     */
    public int[] loop(int[] unsortedArray) {
        for (int start = 0; start < unsortedArray.length; ++start) {
            count++;
            int minIndex = findTheMiniIndex(unsortedArray, start);
            swap(unsortedArray, minIndex, start);
        }
        return unsortedArray;
    }

    /**
     * @param arr
     * @param start
     * @return
     */
    public int findTheMiniIndex(int[] arr, int start) {
        int index = start;
        for (int i = start + 1; i < arr.length; ++i) {
            if (arr[index] > arr[i]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * @param swapValOfArr
     * @param minIndex
     * @param start
     */
    public void swap(int[] swapValOfArr, int minIndex, int start) {
        int temp = swapValOfArr[minIndex];
        swapValOfArr[minIndex] = swapValOfArr[start];
        swapValOfArr[start] = temp;
    }
}

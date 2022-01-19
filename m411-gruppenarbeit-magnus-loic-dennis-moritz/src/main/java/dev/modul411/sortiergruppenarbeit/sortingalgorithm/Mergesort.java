package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;

/**
 * @Author Magnus Götz
 * @Since 2022-01-04
 * @Version 1.0
 */


public class Mergesort implements Sorter {
    private int count = 0;

    public Mergesort() {
    }

    @Override
    public void sort(int[] unsortedArray, Measure measure) {
        //sort
        int[] sortedARR = loop(unsortedArray);

        measure.setComparison(count);
        measure.setSortedArray(sortedARR);
    }

    @Override
    public String getAlgorithmName() {
        return "Mergesort";
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

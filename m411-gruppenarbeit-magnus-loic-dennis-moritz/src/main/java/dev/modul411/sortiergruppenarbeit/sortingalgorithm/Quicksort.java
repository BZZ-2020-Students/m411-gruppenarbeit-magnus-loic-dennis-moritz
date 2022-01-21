package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;

/**
 * Quicksort class sorts the values using the quicksort
 *
 * @Author Magnus Götz, Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */

public class Quicksort implements Sorter {

    private int[] unsortedArray;
    private int count = 0;

    /**
     * Default constructor
     */
    public Quicksort() {
    }

    /**
     * Handels the sorting with the quicksort
     *
     * @param unsortedArray the array which will be sorted
     * @param measure       to measure the different information about the quicksort
     */
    @Override
    public void sort(int[] unsortedArray, Measure measure) {
        this.unsortedArray = unsortedArray;

        //sort
        sorting(0, unsortedArray.length - 1);

        measure.setComparison(count);
        measure.setSortedArray(unsortedArray);
    }

    /**
     * @return the name of the sort
     */
    @Override
    public String getAlgorithmName() {
        return "Quicksort";
    }

//    /**
//     * @param leftPos
//     * @param rightPos
//     */
//    public Quicksort(int leftPos, int rightPos) {
//        if (leftPos < rightPos) {
//            int middlePos = split(leftPos, rightPos);
//            new Quicksort(leftPos, middlePos - 1);
//            new Quicksort(middlePos + 1, rightPos);
//        }
//    }

    /**
     * @param leftPos
     * @param rightPos
     */
    private void sorting(int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int middlePos = split(leftPos, rightPos);
            sorting(leftPos, middlePos - 1);
            sorting(middlePos + 1, rightPos);
        }
    }

    /**
     * @param leftPos
     * @param rightPos
     * @return
     */
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

    /**
     * @param leftPos
     * @param rightPos
     */
    public void swap(int leftPos, int rightPos) {
        int temp = unsortedArray[rightPos];
        unsortedArray[rightPos] = unsortedArray[leftPos];
        unsortedArray[leftPos] = temp;
    }


}

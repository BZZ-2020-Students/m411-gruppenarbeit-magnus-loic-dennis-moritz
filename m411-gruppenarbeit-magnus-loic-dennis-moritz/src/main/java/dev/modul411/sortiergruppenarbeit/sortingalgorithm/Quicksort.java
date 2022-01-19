package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;

/**
 * @Author Magnus Götz
 * @Since 2022-01-04
 * @Version 1.0
 */

public class Quicksort implements Sorter {

    private int[] unsortedArray;
    private int count = 0;

    @Override
    public void sort(int[] unsortedArray, Measure measure) {
        this.unsortedArray = unsortedArray;

        //sort
        sorting(0, unsortedArray.length - 1);

        measure.setComparison(count);
        measure.setSortedArray(unsortedArray);
    }

    @Override
    public String getAlgorithmName() {
        return "Quicksort";
    }

    private void sorting(int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int middlePos = split(leftPos, rightPos);
            sorting(leftPos, middlePos - 1);
            sorting(middlePos + 1, rightPos);
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

    public Quicksort() {
    }
}

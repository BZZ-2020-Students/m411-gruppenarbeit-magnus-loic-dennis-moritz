package dev.modul411.sortiergruppenarbeit.sortingalgorithm;


import dev.modul411.sortiergruppenarbeit.Measure;


/**
 * Bubblesort Class
 *
 * @author Magnus Götz, Moritz Gasbichler
 * @version 1.0
 * @since 2022-01-04
 */

public class Bubblesort implements Sorter {

    private int[] unsortedArray;
    private int count = 0;

    public Bubblesort() {
    }

    @Override
    public void sort(int[] unsortedArray, Measure measure) {

        this.unsortedArray = unsortedArray;

        //sort
        sorting();
        measure.setComparison(count);
        measure.setSortedArray(unsortedArray);
    }

    @Override
    public String getAlgorithmName() {
        return "Bubblesort";
    }

    private void sorting() {
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

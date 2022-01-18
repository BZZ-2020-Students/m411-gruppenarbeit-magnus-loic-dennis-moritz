package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import dev.modul411.sortiergruppenarbeit.Measure;
import dev.modul411.sortiergruppenarbeit.Sort;

public class Demo {
    public static void main(String[] args) {
        new Demo().run();
    }

    public void run(){
        int[] sr = {32514,32423423,3432,4351,3613455,145,4636154,63164356,17438547,874563456,1233334,13421};
        Mergesort m = new Mergesort();
        Sort sort = new Sort();
        Measure measure = new Measure();

        sort.sort(m,sr,measure);

        System.out.println("Time: " + measure.getTime());
        System.out.println("Memory: " + measure.getMemory());
        System.out.println("Comparisons: " + measure.getComparison());

    }
}

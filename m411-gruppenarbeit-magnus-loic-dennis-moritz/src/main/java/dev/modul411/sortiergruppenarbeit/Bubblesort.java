package dev.modul411.sortiergruppenarbeit;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Bubblesort {

    private int[] unsortedArray;
    private long[] measure = new long[3];
    private int count = 0;


    public static void main(String[] args) {
        new Bubblesort().run();
    }

    public void run(){
        long startTime;

        //Measure memory
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        //Measure time
        startTime = new Date().getTime();

        sort();

        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");
        measure[0] = new Date().getTime() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore));
        measure[1] = usedMemoryAfter-usedMemoryBefore;

        measure[2] = count;
    }

    public Bubblesort(){
    }

    public long[] Bubblesort(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;

        return measure;
    }

    private void sort() {
        boolean finish;
    	 for(int a = 0; a < unsortedArray.length - 1; a++){
             finish = true;
            for(int b = 0; b < unsortedArray.length - a - 1; b++){
                count++;
               if(unsortedArray[b] > unsortedArray[b + 1]){
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

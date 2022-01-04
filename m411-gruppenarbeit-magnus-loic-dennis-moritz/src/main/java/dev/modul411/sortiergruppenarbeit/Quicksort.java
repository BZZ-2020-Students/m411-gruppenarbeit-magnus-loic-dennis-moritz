package dev.modul411.sortiergruppenarbeit;

import java.util.Date;
import java.util.Random;

public class Quicksort {
    static int[] unsortedArray;


    public static void main(String[] args) {
        long startTime;
        Quicksort programm = new Quicksort();
        startTime = new Date().getTime();
        programm.sort(0, unsortedArray.length - 1);
        System.out.println("Dauer der Sortierung: " + (new Date().getTime() - startTime) + "ms");;
    }

    Quicksort(){
    }

    Quicksort(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    private void sort(int leftPos, int rightPos) {
        if (leftPos < rightPos){
            int middlePos = split(leftPos, rightPos);
            sort(leftPos, middlePos-1);
            sort(middlePos + 1, rightPos);
        }
    }
    public Quicksort(int leftPos, int rightPos){
        if (leftPos < rightPos){
            int middlePos = split(leftPos, rightPos);
            new Quicksort(leftPos, middlePos-1);
            new Quicksort(middlePos + 1, rightPos);
        }
    }

    public int split(int leftPos, int rightPos){
        int pivotPos = leftPos;
        while (leftPos < rightPos){
            if (unsortedArray[rightPos] > unsortedArray[pivotPos]){
                rightPos--;
            }else{
                if (unsortedArray[leftPos] <= unsortedArray[pivotPos])
                    leftPos++;
                else
                    swap(leftPos, rightPos);
            }
        }
        swap(pivotPos, rightPos);
        return rightPos;
    }

    public void swap(int leftPos, int rightPos){
        int temp = unsortedArray[rightPos];
        unsortedArray[rightPos] = unsortedArray[leftPos];
        unsortedArray[leftPos] = temp;
    }
}

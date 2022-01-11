package dev.modul411.sortiergruppenarbeit.sortingalgorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Demo {
    public static void main(String[] args) {
        new Demo().run();
    }

    public void run(){
        int[] sr = {32514,32423423,3432,4351,3613455,145,4636154,63164356,17438547,874563456,1233334,13421};
        Mergesort m = new Mergesort();

        long[] arr = m.run(sr);
        System.out.println(arr[0]);
        Instant endTimeInstant = Instant.now().truncatedTo(ChronoUnit.MICROS);
        long endTime = endTimeInstant.getNano() / 1000;
        System.out.println(endTime);
    }
}

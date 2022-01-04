package dev.modul411.sortiergruppenarbeit;

import dev.modul411.sortiergruppenarbeit.importfile.ReadFile;

/**
 * Main Class
 *
 * @author Dennis Woodtli, Loic Flückiger, Magnus Götz, Moritz Gasbichler
 * @version 1.0
 * @since 2022-01-04
 */
public class Main {
    private final String pathPrefix = "src/main/resources/importfiels/";
    private int[] tenDigits;
    private int[] hundredDigits;
    private int[] thousandDigits;

    public Main() {
        getImputs();
    }

    public void getImputs() {
        ReadFile readFile = new ReadFile();


        tenDigits = readFile.readLinesFromFile(pathPrefix + "10Digits.dat");
        System.out.println("The Digits of the 10 Digits File: ");
        printDigits(tenDigits);

        hundredDigits = readFile.readLinesFromFile(pathPrefix + "100Digits.dat");
        System.out.println("The Digits of the 100 Digits File: ");
        printDigits(hundredDigits);

        thousandDigits = readFile.readLinesFromFile(pathPrefix + "1000Digits.dat");
        System.out.println("The Digits of the 1000 Digits File: ");
        printDigits(thousandDigits);
    }

    private void printDigits(int[] digits) {
        for (int i : digits) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        int[] unsortedArray = {432324,234234,235,32523,534,643,6,3256,3476,5346356,4235,6};
        Bubblesort b = new Bubblesort();
        long[] arr = b.run(unsortedArray);
    }
}

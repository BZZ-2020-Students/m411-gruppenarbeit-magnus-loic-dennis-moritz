package dev.modul411.sortiergruppenarbeit.importexport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Author Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */
public class ImportFile {

    public ImportFile() {

    }

    public int[] readLinesFromFile(String path) {
        ArrayList<Integer> numberLinesAsArrayList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            Object[] string = stream.toArray();
            for (Object o : string) {
                if (checkStringValidInt((String) o)) {
                    numberLinesAsArrayList.add(Integer.parseInt((String) o));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] fileValuesAsIntArray = new int[numberLinesAsArrayList.size()];

        for (int i = 0; i < fileValuesAsIntArray.length; i++) {
            fileValuesAsIntArray[i] = numberLinesAsArrayList.get(i);
        }

        return fileValuesAsIntArray;
    }

    public boolean checkStringValidInt(String stringToTest) {
        try {
            Integer.parseInt(stringToTest);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}

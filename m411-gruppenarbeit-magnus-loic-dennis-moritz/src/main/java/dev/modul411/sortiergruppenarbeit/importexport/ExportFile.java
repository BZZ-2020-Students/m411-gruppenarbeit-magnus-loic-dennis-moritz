package dev.modul411.sortiergruppenarbeit.importexport;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */

public class ExportFile {
    private String filemame;
    private ArrayList<String[]> sortingValues;

    public ExportFile(String filename, ArrayList<String[]> sortingValues) {
        this.filemame = filename;
        this.sortingValues = sortingValues;
    }

    public void writeInCsvFile() {
        //TODO Get real data not just testdata
        File file = new File(filemame);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"Sortingalgorithm", "Memory used", "Comparisons done", "Time needed in seconds"};
            writer.writeNext(header);
            for (String[] s : sortingValues) {
                writer.writeNext(s);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilemame() {
        return filemame;
    }

    public void setFilemame(String filemame) {
        this.filemame = filemame;
    }

}

package dev.modul411.sortiergruppenarbeit.importexport;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Moritz Gasbichler
 * @Since 2022-01-04
 * @Version 1.0
 */
public class ExportFile {
    private String filemame;
    private String[] bubblesortValues;
    private String[] mergesortValues;
    private String[] quicksortValues;
    public ExportFile(String filename) {
        this.filemame = filename;
    }
    public ExportFile(String filename, String[] bubblesortValues, String[] mergesortValues, String[] quicksortValues) {
        this.filemame = filename;
        this.bubblesortValues = bubblesortValues;
        this.mergesortValues = mergesortValues;
        this.quicksortValues = quicksortValues;
    }
    public void writeInCsvFile(){
        //TODO Get real data not just testdata
        System.out.println("!! EXPORT JUST WORKING WITH TEST DATA !!");
        File file = new File(filemame);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"Sorting algorithm", "Memory used", "Comparisons", "Time needed"};
            writer.writeNext(header);

            // add data to csv
            writer.writeNext(bubblesortValues);
            writer.writeNext(mergesortValues);
            writer.writeNext(quicksortValues);

            // closing writer connection
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

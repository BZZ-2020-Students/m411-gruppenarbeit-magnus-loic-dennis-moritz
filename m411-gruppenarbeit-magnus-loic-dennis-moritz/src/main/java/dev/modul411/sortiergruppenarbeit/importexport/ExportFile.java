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
    public ExportFile() {
        //TODO Get real data not just testdata
        System.out.println("!! EXPORT JUST WORKING WITH TEST DATA !!");
        File file = new File("exportFile.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {"Name", "Class", "Marks"};
            writer.writeNext(header);

            // add data to csv
            String[] data1 = {"Aman", "10", "620"};
            writer.writeNext(data1);
            String[] data2 = {"Suraj", "10", "630"};
            writer.writeNext(data2);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

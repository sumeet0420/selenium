package com.triscent.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CSVUtils {

    private static String filePath;
    private static List<String> csvFile;

    public static String[][] readCSV(String fileName) {
        if (!fileName.endsWith(".csv"))
            try {
                throw new Exception("Invalid File Format.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        return readOtherDemiliterFile(fileName,",");
    }

    public static String[][] readOtherDemiliterFile(String fileName, String demiliter) {

        filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
                + "main" + File.separator + "resources" + File.separator + fileName;
        String[][] csvData = null;
        try {
            csvFile = Files.readAllLines(Paths.get(filePath));
            if (csvFile.size() > 0) {
                int noOfColumns = csvFile.get(0).split(demiliter).length;
                int noOfRows = csvFile.size() - 1;
                csvData = new String[noOfRows][noOfColumns];
                for (int i = 1; i < csvFile.size(); i++) {
                    String[] columnData = csvFile.get(i).split(demiliter);
                    for (int j = 0; j < columnData.length; j++) {
                        csvData[i - 1][j] = columnData[j];
                    }
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        return csvData;
    }

    public static void main(String[] args){
        String[][] csv = readCSV("userdetails.csv");
        System.out.println(csv[0][1]);
    }
}

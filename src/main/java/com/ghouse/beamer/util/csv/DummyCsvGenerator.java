package com.ghouse.beamer.util.csv;

import com.ghouse.beamer.util.TestingUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DummyCsvGenerator {
    public static void main(String[] args) {
        String fileName = TestingUtil.getTestFolder() + "test_file_1.csv"; // Ensure TestingUtil.getTestFolder() returns the correct path
        List<String> headers = List.of("Row1", "Row2", "Row3", "Row4", "Row5");
        int numOfLines = 1000;
        generateCsvFile(fileName, headers, numOfLines);
    }

    private static void generateCsvFile(String fileName, List<String> headers, int numOfLines) {
        try {
            FileWriter csvWriter = new FileWriter(Paths.get(fileName).toFile());

            csvWriter.append(String.join(",", headers));
            csvWriter.append("\n");

            for (int i = 1; i <= numOfLines; i++) {
                String[] rowData = new String[headers.size()];
                for (int j = 0; j < headers.size(); j++) {
                    rowData[j] = headers.get(j) + "-" + i;
                }
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("CSV file created: " + fileName);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}


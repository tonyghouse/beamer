package com.ghouse.beamer.util.text;

import com.ghouse.beamer.util.TestingUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DummyTextFileGenerator {
    public static void main(String[] args) {
        String fileName = TestingUtil.getTestFolder() + "test_file_1.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            int numOfLines = 10;
            for (int i = 1; i <= numOfLines; i++) {
                String dummyString = "X-" + i;
                writer.write(dummyString);
                writer.newLine();
            }
            System.out.println("File created successfully with " + numOfLines + " dummy strings in the resources directory.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

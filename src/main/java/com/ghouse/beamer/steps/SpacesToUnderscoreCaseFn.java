package com.ghouse.beamer.steps;

import com.ghouse.beamer.util.TestingUtil;
import com.ghouse.beamer.util.text.TextFileUtil;
import org.apache.beam.sdk.transforms.DoFn;

import java.util.ArrayList;
import java.util.List;


public class SpacesToUnderscoreCaseFn extends DoFn<String, String> {

    @Setup
    public void setup(){
        System.out.println("\nSetup SpacesToUnderscoreCaseFn called");
    }

    @Teardown
    public void teardown(){
        System.out.println("\nTearDown SpacesToUnderscoreCaseFn called");
    }


    @ProcessElement
    public void processElement(ProcessContext processContext) {
        String fileName = processContext.element();
        List<String> rows = TextFileUtil.readFromTextFile(fileName);

        List<String> convertedRows = new ArrayList<>();
        for(String row: rows){
            String result = row.replaceAll("\\s","_");
            convertedRows.add(result);

        }

        String outputFileName = TestingUtil.getTestFolder() + "SpacesToUnderscoreCaseFn_file_1.txt";
        TextFileUtil.writeToTextFile(convertedRows, outputFileName);
        processContext.output(outputFileName);
    }
}
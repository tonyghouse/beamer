package com.ghouse.beamer.steps;


import com.ghouse.beamer.util.StringUtil;
import com.ghouse.beamer.util.TestingUtil;
import com.ghouse.beamer.util.text.TextFileUtil;
import org.apache.beam.sdk.transforms.DoFn;

import java.util.ArrayList;
import java.util.List;


public class ReplaceSpecialCharactersFn extends DoFn<String, String> {

    @Setup
    public void setup(){
        System.out.println("\nSetup ReplaceSpecialCharactersFn called");
    }

    @Teardown
    public void teardown(){
        System.out.println("\nTearDown ReplaceSpecialCharactersFn called");
    }

    @ProcessElement
    public void processElement(ProcessContext context) {
        String fileName = context.element();
        List<String> rows = TextFileUtil.readFromTextFile(fileName);

        List<String> convertedRows = new ArrayList<>();
        for(String row: rows){
            String result = StringUtil.replaceSpecialCharactersWithNames(row);
            convertedRows.add(result);

        }

        String outputFileName = TestingUtil.getTestFolder() + "ReplaceSpecialCharactersFn_file_1.txt";
        TextFileUtil.writeToTextFile(convertedRows, outputFileName);
        context.output(outputFileName);
    }

}
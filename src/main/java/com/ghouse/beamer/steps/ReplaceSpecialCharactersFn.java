package com.ghouse.beamer.steps;


import com.ghouse.beamer.util.StringUtil;
import org.apache.beam.sdk.transforms.DoFn;


public class ReplaceSpecialCharactersFn extends DoFn<String, String> {

    @Setup
    public void setup(){
        //System.out.println("\nSetup ReplaceSpecialCharactersFn called");
    }

    @Teardown
    public void teardown(){
        //System.out.println("\nTearDown ReplaceSpecialCharactersFn called");
    }

    @ProcessElement
    public void processElement(ProcessContext context) {
        String input = context.element();
        String result = StringUtil.replaceSpecialCharactersWithNames(input);
        context.output(result);
    }





}
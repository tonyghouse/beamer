package com.ghouse.beamer.steps;

import org.apache.beam.sdk.transforms.DoFn;


public class UpperCaseFn extends DoFn<String, String> {

    @Setup
    public void setup(){
        //System.out.println("\nSetup UpperCaseFn called");
    }

    @Teardown
    public void teardown(){
        //System.out.println("\nTearDown UpperCaseFn called");
    }


    @ProcessElement
    public void processElement(ProcessContext processContext) {
        String input = processContext.element();
        String result = input.toUpperCase();
        processContext.output(result);
    }
}
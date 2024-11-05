package com.ghouse.beamer.steps;

import org.apache.beam.sdk.transforms.DoFn;


public class SpacesToUnderscoreCaseFn extends DoFn<String, String> {

    @Setup
    public void setup(){
        //System.out.println("\nSetup SpacesToUnderscoreCaseFn called");
    }

    @Teardown
    public void teardown(){
        //System.out.println("\nTearDown SpacesToUnderscoreCaseFn called");
    }


    @ProcessElement
    public void processElement(ProcessContext processContext) {
        String input = processContext.element();
        String result = input.replaceAll("\\s", "_");
        processContext.output(result);
    }
}
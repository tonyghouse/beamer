package com.ghouse.beamer.steps;

import org.apache.beam.sdk.transforms.DoFn;


public class OutputPrinterFn extends DoFn<String, String> {

    @Setup
    public void setup(){
        System.out.println("\nSetup OutputPrinterFn called");
    }

    @Teardown
    public void teardown(){
        System.out.println("\nTearDown OutputPrinterFn called");
    }


    @ProcessElement
    public void processElement(ProcessContext processContext) {
        String input = processContext.element();
        System.out.println(">> "+input);
        processContext.output(input);
    }
}
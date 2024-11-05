package com.ghouse.beamer.steps;

import com.ghouse.beamer.util.ThreadUtil;
import org.apache.beam.sdk.transforms.DoFn;

import java.util.concurrent.TimeUnit;


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
        String fileName = processContext.element();
        System.out.println(">> "+fileName);
        processContext.output(fileName);
    }
}
package com.ghouse.beamer.service;

import com.ghouse.beamer.steps.OutputPrinterFn;
import com.ghouse.beamer.steps.ReplaceSpecialCharactersFn;
import com.ghouse.beamer.steps.SpacesToUnderscoreCaseFn;
import com.ghouse.beamer.steps.UpperCaseFn;
import com.ghouse.beamer.util.TestingUtil;
import org.apache.beam.runners.direct.DirectOptions;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.springframework.stereotype.Service;

import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.values.PCollection;

@Service
public class DataProcessorService {
    public String processData() {
        String fileName = TestingUtil.getTestFolder() + "test_file_1.txt";
        List<String> input = List.of(fileName);

        PipelineOptions options = PipelineOptionsFactory.create();
        options.as(DirectOptions.class).setTargetParallelism(30);
        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> inputPCollection = pipeline.apply(Create.of(input));
        PCollection<String> replaceSpecialCharactersFnOutput = inputPCollection.apply(ParDo.of(new ReplaceSpecialCharactersFn()));
        PCollection<String> spacesToUnderscoreCaseFnOutput = replaceSpecialCharactersFnOutput.apply(ParDo.of(new SpacesToUnderscoreCaseFn()));
        PCollection<String> upperCaseFnOutput = spacesToUnderscoreCaseFnOutput.apply(ParDo.of(new UpperCaseFn()));
        PCollection<String> outputPrinterFnOutput = upperCaseFnOutput.apply(ParDo.of(new OutputPrinterFn()));


        PipelineResult.State state = pipeline.run().waitUntilFinish();

        return state.name();
    }

//    private List<String> getLargeDummyList() {
//        List<String> dataList = new ArrayList<>();
//        for (int i = 1; i <= 100000; i++) {
//            dataList.add("X-" + i);
//        }
//        return dataList;
//    }

//    private List<String> getDataList(List<Voter> voters) {
//        List<String> dataList = new ArrayList<>();
//
//        for (Voter voter : voters) {
//            dataList.add(voter.getName());
//        }
//        return dataList;
//    }
}

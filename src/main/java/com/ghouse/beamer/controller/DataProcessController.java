package com.ghouse.beamer.controller;

import com.ghouse.beamer.model.Voter;
import com.ghouse.beamer.service.DataProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataProcessController {

    @Autowired
    private DataProcessorService dataProcessService;

    @PostMapping("/process")
    public ResponseEntity<String> processData(@RequestBody List<Voter> voters) {
        String result = dataProcessService.processData();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}

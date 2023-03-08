package com.irctc.IRCTC.controller;

import com.irctc.IRCTC.entity.Passenger;
import com.irctc.IRCTC.entity.Train;
import com.irctc.IRCTC.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainService trainService;
    @PostMapping("/")
    public Train addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }
}

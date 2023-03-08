package com.irctc.IRCTC.service;

import com.irctc.IRCTC.entity.Train;
import com.irctc.IRCTC.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;


    public Train addTrain(Train train){
        trainRepository.save(train);
        return train;
    }


}

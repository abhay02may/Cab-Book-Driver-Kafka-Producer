package com.dailycodebuffer.producer.service;

import com.dailycodebuffer.producer.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updateCabLocation(String location){
        kafkaTemplate.send(AppConstants.CAB_LOCATION,location);
        return true;
    }

}

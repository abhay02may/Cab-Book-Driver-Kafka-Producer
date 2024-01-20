package com.dailycodebuffer.producer.controller;

import com.dailycodebuffer.producer.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity updateLocation(){
        int range=100;
        StringBuilder sbr=new StringBuilder();
        while(range>0){
            sbr.append(Math.random()+" , "+Math.random());
            try{
                cabLocationService.updateCabLocation(sbr.toString());
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            range--;
        }
        System.out.println("Location Data sent to topic:\n"+sbr.toString());
        return new ResponseEntity(Map.of("message",sbr.toString()), HttpStatus.OK);
    }
}

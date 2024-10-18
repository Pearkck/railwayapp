package com.kotchakorn.railwayapp.controller;

import com.kotchakorn.railwayapp.dto.TrainDto;
import com.kotchakorn.railwayapp.service.TrainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/trains")
public class TrainController {

    private TrainService trainService;

    @PostMapping
    public ResponseEntity<TrainDto> createTrain(@RequestBody TrainDto trainDto){
        TrainDto savedTrain = trainService.createTrain(trainDto);
        return new ResponseEntity<>(savedTrain, HttpStatus.CREATED);
    }

    @GetMapping("{trainId}")
    public ResponseEntity<TrainDto> getTrainById(@PathVariable("trainId") Long trainId){
        TrainDto trainDto = trainService.getTrainById(trainId);
        return ResponseEntity.ok(trainDto);
    }

    @GetMapping
    public ResponseEntity<List<TrainDto>> getAllTrains(){
        List<TrainDto> trains = trainService.getAllTrains();
        return ResponseEntity.ok(trains);
    }

    @PutMapping("{trainId}")
    public ResponseEntity<TrainDto> updateTrain(@PathVariable("trainId") Long trainId,
                                              @RequestBody TrainDto updatedTrain){
        TrainDto trainDto = trainService.updateTrain(trainId, updatedTrain);
        return ResponseEntity.ok(trainDto);
    }

    @DeleteMapping("{trainId}")
    public ResponseEntity<String> deleteTrain(@PathVariable("trainId") Long trainId){
        trainService.deleteTrain(trainId);
        return ResponseEntity.ok("Train deleted successfully!");
    }
}

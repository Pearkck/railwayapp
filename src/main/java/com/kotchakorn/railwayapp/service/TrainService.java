package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.dto.TrainDto;

import java.util.List;

public interface TrainService {
    TrainDto createTrain(TrainDto trainDto);

    TrainDto getTrainById(Long trainId);

    List<TrainDto> getAllTrains();

    TrainDto updateTrain(Long trainId, TrainDto updatedTrain);

    void deleteTrain(Long trainId);
}

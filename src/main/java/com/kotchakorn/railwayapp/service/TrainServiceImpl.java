package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.dto.TrainDto;
import com.kotchakorn.railwayapp.entity.Train;
import com.kotchakorn.railwayapp.exceptions.ResourceNotFoundException;
import com.kotchakorn.railwayapp.mapper.TrainMapper;
import com.kotchakorn.railwayapp.repository.TrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrainServiceImpl implements TrainService{

    private TrainRepository trainRepository;

    @Override
    public TrainDto createTrain(TrainDto trainDto) {

        Train train = TrainMapper.mapTotrain(trainDto);
        Train savedTrain = trainRepository.save(train);
        return TrainMapper.mapToTrainDto(savedTrain);
    }

    @Override
    public TrainDto getTrainById(Long trainId) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Train is not exists with given id : " + trainId));
        return TrainMapper.mapToTrainDto(train);
    }

    @Override
    public List<TrainDto> getAllTrains() {
        List<Train> trains = trainRepository.findAll();
        return trains.stream().map(TrainMapper::mapToTrainDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrainDto updateTrain(Long trainId, TrainDto updatedTrain) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Train is not exists with given id : " + trainId));

        train.setArrivalTime(updatedTrain.getArrivalTime());
        train.setDepartureTime(updatedTrain.getDepartureTime());
        train.setOriginStation(updatedTrain.getOriginStation());
        train.setDestinationStation(updatedTrain.getDestinationStation());
        train.setSeatCapacity(updatedTrain.getSeatCapacity());
        train.setTicketPrice(updatedTrain.getTicketPrice());


        Train updatedTrainObj = trainRepository.save(train);

        return TrainMapper.mapToTrainDto(updatedTrainObj);
    }

    @Override
    public void deleteTrain(Long trainId) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Train is not exists with given id : " + trainId));

        trainRepository.deleteById(trainId);
    }
}

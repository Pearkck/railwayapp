package com.kotchakorn.railwayapp.mapper;


import com.kotchakorn.railwayapp.dto.TrainDto;
import com.kotchakorn.railwayapp.entity.Train;

public class TrainMapper {

    public static TrainDto mapToTrainDto(Train train){
        return new TrainDto(
                train.getTrainId(),
                train.getDepartureTime(),
                train.getArrivalTime(),
                train.getOriginStation(),
                train.getDestinationStation(),
                train.getSeatCapacity(),
                train.getTicketPrice()
        );
    }

    public static Train mapTotrain(TrainDto trainDto){
        return new Train(
                trainDto.getTrainId(),
                trainDto.getDepartureTime(),
                trainDto.getArrivalTime(),
                trainDto.getOriginStation(),
                trainDto.getDestinationStation(),
                trainDto.getSeatCapacity(),
                trainDto.getTicketPrice()
        );
    }
}

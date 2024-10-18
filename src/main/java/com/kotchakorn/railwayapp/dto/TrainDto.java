package com.kotchakorn.railwayapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto {

    private Long trainId;
    private String departureTime;
    private String arrivalTime;
    private String originStation;
    private String destinationStation;
    private int seatCapacity;
    private double ticketPrice;
}

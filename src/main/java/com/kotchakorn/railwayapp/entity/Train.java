package com.kotchakorn.railwayapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trains")
public class Train {

    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "origin_station")
    private String originStation;

    @Column(name = "destination_station")
    private String destinationStation;

    @Column(name = "seat_capacity")
    private int seatCapacity;

    @Column(name = "ticket_price")
    private double ticketPrice;

}

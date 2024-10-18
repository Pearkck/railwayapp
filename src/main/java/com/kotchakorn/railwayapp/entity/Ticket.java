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
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "train_id")
    private Long trainId;

    @Column(name = "departure_date")
    private String departureDate;

}

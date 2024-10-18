package com.kotchakorn.railwayapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long ticketId;
    private String passengerName;
    private int seatNumber;
    private Long trainId;
    private String departureDate;
}

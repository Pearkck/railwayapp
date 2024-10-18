package com.kotchakorn.railwayapp.mapper;


import com.kotchakorn.railwayapp.dto.TicketDto;
import com.kotchakorn.railwayapp.entity.Ticket;

public class TicketMapper {

    public static TicketDto mapToTicketDto(Ticket ticket){
        return new TicketDto(
                ticket.getTicketId(),
                ticket.getPassengerName(),
                ticket.getSeatNumber(),
                ticket.getTrainId(),
                ticket.getDepartureDate()
        );
    }

    public static Ticket mapToTicket(TicketDto ticketDto){
        return new Ticket(
                ticketDto.getTicketId(),
                ticketDto.getPassengerName(),
                ticketDto.getSeatNumber(),
                ticketDto.getTrainId(),
                ticketDto.getDepartureDate()
        );
    }
}

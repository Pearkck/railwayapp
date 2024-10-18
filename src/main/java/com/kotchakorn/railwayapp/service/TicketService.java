package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);

    TicketDto getTicketById(Long ticketId);

    List<TicketDto> getAllTickets();

    TicketDto updateTicket(Long ticketId, TicketDto updatedTicket);

    void deleteTicket(Long ticketId);
}

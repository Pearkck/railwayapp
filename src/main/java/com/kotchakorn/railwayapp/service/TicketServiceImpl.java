package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.dto.TicketDto;
import com.kotchakorn.railwayapp.entity.Ticket;
import com.kotchakorn.railwayapp.exceptions.ResourceNotFoundException;
import com.kotchakorn.railwayapp.mapper.TicketMapper;
import com.kotchakorn.railwayapp.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToTicket(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketMapper.mapToTicketDto(savedTicket);
    }

    @Override
    public TicketDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket is not exists with given id : " + ticketId));
        return TicketMapper.mapToTicketDto(ticket);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(TicketMapper::mapToTicketDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto updateTicket(Long ticketId, TicketDto updatedTicket) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket is not exists with given id : " + ticketId));

        ticket.setPassengerName(updatedTicket.getPassengerName());
        ticket.setSeatNumber(updatedTicket.getSeatNumber());
        ticket.setTrainId(updatedTicket.getTrainId());
        ticket.setDepartureDate(updatedTicket.getDepartureDate());


        Ticket updatedTicketObj = ticketRepository.save(ticket);

        return TicketMapper.mapToTicketDto(updatedTicketObj);
    }

    @Override
    public void deleteTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket is not exists with given id : " + ticketId));

        ticketRepository.deleteById(ticketId);
    }
}

package com.kotchakorn.railwayapp.controller;

import com.kotchakorn.railwayapp.dto.TicketDto;
import com.kotchakorn.railwayapp.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/trains/tickets")
public class TicketController {

    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto){
        TicketDto savedTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable("ticketId") Long ticketId){
        TicketDto TicketDto = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(TicketDto);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        List<TicketDto> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("{ticketId}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable("ticketId") Long ticketId,
                                                @RequestBody TicketDto updatedTicket){
        TicketDto ticketDto = ticketService.updateTicket(ticketId, updatedTicket);
        return ResponseEntity.ok(ticketDto);
    }

    @DeleteMapping("{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Long ticketId){
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.ok("Ticket deleted successfully!");
    }
}

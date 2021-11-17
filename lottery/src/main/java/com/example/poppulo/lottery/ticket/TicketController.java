package com.example.poppulo.lottery.ticket;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public Ticket addTicket(Long numberOfLines) {
        return ticketService.addNewTicket(numberOfLines);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> findAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketService.findTicketById(ticketId));
    }

    @PutMapping
    public ResponseEntity<Ticket> updateTicket(Long ticketId, Long numberOfLines) {
        return ResponseEntity.ok(ticketService.updateTicket(ticketId, numberOfLines));
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Ticket> getTicketStatus(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketService.getTicketStatus(ticketId));
    }
}

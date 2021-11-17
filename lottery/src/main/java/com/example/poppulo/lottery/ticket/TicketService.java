package com.example.poppulo.lottery.ticket;

import com.example.poppulo.lottery.line.Line;
import com.example.poppulo.lottery.line.LineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    private final LineService lineService;

    public Ticket addNewTicket(Long numberOfLines) {
        List<Line> randomlyGeneratedLines = lineService.generateLines(numberOfLines);
        Ticket ticket = new Ticket(randomlyGeneratedLines);
        return ticketRepository.saveAndFlush(ticket);
    }

    public Ticket findTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> {
            throw new RuntimeException("Ticket Not Found.");
        });
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> ticketList = ticketRepository.findAll();

        if (!ticketList.isEmpty()) {
            return ticketList;
        } else {
            throw new RuntimeException("No tickets found.");
        }
    }

    public Ticket updateTicket(Long ticketId, Long numberOfNewLines) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> {
            throw new RuntimeException("Ticket Not Found.");
        });

        if (ticket.isTicketChecked()) {
            throw new RuntimeException("Ticket Already Checked, no longer allowed to update.");
        }
        List <Line> updatedList = Stream.concat
                (ticket.getLineList().stream(), lineService.generateLines(numberOfNewLines).stream())
                .collect(Collectors.toList());

        ticket.setLineList(updatedList);
        return ticketRepository.saveAndFlush(ticket);
    }

    public Ticket getTicketStatus(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> {
            throw new RuntimeException("Ticket Not Found.");
        });

        if (!ticket.isTicketChecked()) {
            ticket.setTicketChecked(true);
            ticketRepository.saveAndFlush(ticket);
        }
        List<Line> sortedListByResult = ticket.getLineList()
                .stream()
                .sorted(Comparator.comparing(Line::getResult))
                .collect(Collectors.toList());

        ticket.setLineList(sortedListByResult);

        return ticket;
    }
}

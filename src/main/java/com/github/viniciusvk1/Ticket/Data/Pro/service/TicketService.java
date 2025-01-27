package com.github.viniciusvk1.Ticket.Data.Pro.service;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import com.github.viniciusvk1.Ticket.Data.Pro.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findOpenTickets() {
        return ticketRepository.findOpenTickets();
    }

    public List<Ticket> findTicketsByDeveloper(String developer) {
        return ticketRepository.findTicketsByDeveloper(developer);
    }

    public List<Ticket> findRejectedTickets() {
        return ticketRepository.findRejectedTickets();
    }

    public List<Ticket> findActiveTickets() {
        return ticketRepository.findActiveTickets();
    }

    public List<Ticket> findTicketsByPriority(String priority) {
        return ticketRepository.findTicketsByPriority(priority);
    }
}

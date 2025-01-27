package com.github.viniciusvk1.Ticket.Data.Pro.service;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import com.github.viniciusvk1.Ticket.Data.Pro.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Salvar um único ticket
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Salvar todos os tickets de uma vez
    public List<Ticket> saveAllTickets(List<Ticket> tickets) {
        return ticketRepository.saveAll(tickets);
    }

    // Buscar todos os tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Buscar um ticket por ID
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    // Deletar um ticket
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

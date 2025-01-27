package com.github.viniciusvk1.Ticket.Data.Pro.repository;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

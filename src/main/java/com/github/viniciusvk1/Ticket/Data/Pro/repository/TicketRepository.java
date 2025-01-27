package com.github.viniciusvk1.Ticket.Data.Pro.repository;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.status = 'Abertos'")
    List<Ticket> findOpenTickets();

    @Query("SELECT t FROM Ticket t WHERE t.nomeDesenvolvedor = :desenvolvedor")
    List<Ticket> findTicketsByDeveloper(@Param("desenvolvedor") String desenvolvedor);

    @Query("SELECT t FROM Ticket t WHERE t.statusDocumento = 'Reprovado'")
    List<Ticket> findRejectedTickets();

    @Query("SELECT t FROM Ticket t WHERE t.status = 'Em Progresso'")
    List<Ticket> findActiveTickets();

    @Query("SELECT t FROM Ticket t WHERE t.prioridade = :prioridade")
    List<Ticket> findTicketsByPriority(@Param("prioridade") String prioridade);

}

package com.github.viniciusvk1.Ticket.Data.Pro.controller;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import com.github.viniciusvk1.Ticket.Data.Pro.service.ExcelService;
import com.github.viniciusvk1.Ticket.Data.Pro.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final ExcelService excelService;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(ExcelService excelService, TicketRepository ticketRepository) {
        this.excelService = excelService;
        this.ticketRepository = ticketRepository;
    }

    // Endpoint para importar tickets do Excel
    @PostMapping("/import")
    public String importTickets(@RequestParam String filePath) {
        try {
            excelService.importTicketsFromExcel(filePath);
            return "Tickets imported successfully!";
        } catch (IOException e) {
            return "Error while importing tickets: " + e.getMessage();
        }
    }

    // Endpoint para buscar tickets por status
    @GetMapping("/search")
    public List<Ticket> searchTickets(@RequestParam(value = "status", required = false) String status) {
        List<String> validStatuses = Arrays.asList(
                "Aberta", "Aguardando Desenvolvimento", "Aguardando Homologação", "Aguardando Teste Funcional",
                "Avaliação Técnica", "Avaliação Técnica Fábrica", "Cancelada", "Concluída",
                "Correção de TD", "Correção de Desenvolvimento", "Desenvolvimento", "Desfazer Desenvolvimento",
                "Revisão de Requests/Deploy", "Teste Funcional", "Ticket de Desenvolvimento Pausado", "Validação Técnica"
        );

        if (status != null && !validStatuses.contains(status)) {
            // Retorna erro 400 caso o status fornecido não seja válido
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status");
        }

        // Se o status for fornecido, buscar tickets com o status específico
        if (status != null) {
            return ticketRepository.findByStatusTicket(status);
        }

        // Caso contrário, retorna todos os tickets
        return ticketRepository.findAll();

    }

    // Endpoint para buscar tickets por desenvolvedor
    @GetMapping("/by-developer")
    public List<Ticket> getTicketsByDeveloper(@RequestParam String nomeDesenvolvedor) {
        List<Ticket> tickets = ticketRepository.findByNomeDesenvolvedor(nomeDesenvolvedor);

        if (tickets.isEmpty()) {
            // Retorna erro 404 caso não encontre tickets para o desenvolvedor
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No tickets found for developer: " + nomeDesenvolvedor);
        }

        return tickets;
    }

}

package com.github.viniciusvk1.Ticket.Data.Pro.controller;

import com.github.viniciusvk1.Ticket.Data.Pro.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final ExcelService excelService;

    @Autowired
    public TicketController(ExcelService excelService) {
        this.excelService = excelService;
    }

    // Endpoint para importar os tickets
    @PostMapping("/import")
    public String importTickets(@RequestParam String filePath) {
        try {
            excelService.importTicketsFromExcel(filePath);
            return "Tickets imported successfully!";
        } catch (IOException e) {
            return "Error while importing tickets: " + e.getMessage();
        }
    }
}

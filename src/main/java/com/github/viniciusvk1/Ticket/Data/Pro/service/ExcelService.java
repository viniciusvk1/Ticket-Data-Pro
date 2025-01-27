package com.github.viniciusvk1.Ticket.Data.Pro.service;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import com.github.viniciusvk1.Ticket.Data.Pro.repository.TicketRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    private final TicketRepository ticketRepository;
    private TicketService ticketService;


    @Autowired
    public ExcelService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void importTicketsFromExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        List<Ticket> tickets = new ArrayList<>();

        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Ticket ticket = new Ticket();

            ticket.setStatusTicket(getCellValue(row, 0));
            ticket.setTicket(getCellValue(row, 1));
            ticket.setDescricaoTicket(getCellValue(row, 2));
            ticket.setTipoAssociacao(getCellValue(row, 3));
            ticket.setIdentificacaoAssociacao(getCellValue(row, 4));
            ticket.setDescricaoAssociacao(getCellValue(row, 5));
            ticket.setNomeSolicitante(getCellValue(row, 6));
            ticket.setNomeAvaliadorTecnico(getCellValue(row, 7));
            ticket.setTipoDesenvolvedor(getCellValue(row, 8));
            ticket.setNomeDesenvolvedor(getCellValue(row, 9));
            ticket.setPrioridade(getCellValue(row, 10));
            ticket.setMotivoSolicitacao(getCellValue(row, 11));
            ticket.setEquipeTrabalho(getCellValue(row, 12));
            ticket.setModulo(getCellValue(row, 13));
            ticket.setEtapa(getCellValue(row, 14));
            ticket.setDataCriacaoTicket(parseLocalDateTime(getCellValue(row, 15)));
            ticket.setDataEncerramentoTicket(parseLocalDateTime(getCellValue(row, 16)));
            ticket.setStatusDocumento(getCellValue(row, 17));
            ticket.setTipoSolicitacao(getCellValue(row, 18));
            ticket.setDocumentoReprovado(getCellValue(row, 19));
            ticket.setMotivoReprovacao(getCellValue(row, 20));
            ticket.setComplexidade(getCellValue(row, 21));
            ticket.setVolumeTrabalho(getCellValue(row, 22));
            ticket.setTotalEsforcoPrevistoHs(parseInteger(getCellValue(row, 23)));
            ticket.setPrazoEntregaDesenvolvedor(parseLocalDate(getCellValue(row, 24)));
            ticket.setTotalEsforcoAdicionalHs(parseInteger(getCellValue(row, 25)));
            ticket.setEsforcoPrevistoMaisAdicionalHs(parseInteger(getCellValue(row, 26)));
            ticket.setEsforcoRealHs(parseInteger(getCellValue(row, 27)));
            ticket.setTerminoRealDesenvolvedor(parseLocalDateTime(getCellValue(row, 28)));
            ticket.setStatusDesenvolvimento(getCellValue(row, 29));
            ticket.setChangeRequests(getCellValue(row, 30));
            ticket.setDataAtual(parseLocalDateTime(getCellValue(row, 31)));
            ticket.setDataTratada(parseLocalDateTime(getCellValue(row, 32)));
            ticket.setDataConvertida(parseLocalDateTime(getCellValue(row, 33)));

            tickets.add(ticket);
        }

        ticketRepository.saveAll(tickets);

        workbook.close();
        file.close();
    }


    private String getCellValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    return String.valueOf(cell.getNumericCellValue());
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                default:
                    return "";
            }
        }
        return "";
    }

    private LocalDate parseLocalDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    private LocalDateTime parseLocalDateTime(String value) {
        try {
            return LocalDateTime.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    private Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/tickets/abertos")
    public ResponseEntity<?> getOpenTickets() {
        List<Ticket> tickets = ticketService.findOpenTickets();
        return ResponseEntity.ok(Map.of("status", "Abertos", "tickets", tickets));
    }

    @GetMapping("/tickets/desenvolvedor/{nome}")
    public ResponseEntity<?> getTicketsByDeveloper(@PathVariable String nome) {
        List<Ticket> tickets = ticketService.findTicketsByDeveloper(nome);
        return ResponseEntity.ok(Map.of("desenvolvedor", nome, "tickets", tickets));
    }

    @GetMapping("/tickets/reprovados")
    public ResponseEntity<?> getRejectedTickets() {
        List<Ticket> tickets = ticketService.findRejectedTickets();
        return ResponseEntity.ok(Map.of("status_documento", "Reprovado", "tickets", tickets));
    }

    @GetMapping("/tickets/ativos")
    public ResponseEntity<?> getActiveTickets() {
        List<Ticket> tickets = ticketService.findActiveTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/tickets/prioridade/{prioridade}")
    public ResponseEntity<?> getTicketsByPriority(@PathVariable String prioridade) {
        List<Ticket> tickets = ticketService.findTicketsByPriority(prioridade);
        return ResponseEntity.ok(tickets);
    }



}

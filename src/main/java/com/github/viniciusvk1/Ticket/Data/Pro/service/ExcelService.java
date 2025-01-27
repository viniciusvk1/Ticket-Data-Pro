package com.github.viniciusvk1.Ticket.Data.Pro.service;

import com.github.viniciusvk1.Ticket.Data.Pro.model.Ticket;
import com.github.viniciusvk1.Ticket.Data.Pro.repository.TicketRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    private final TicketRepository ticketRepository;

    @Autowired
    public ExcelService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Método para ler e importar os dados de um arquivo Excel
    public void importTicketsFromExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);  // Supondo que os dados estão na primeira aba
        Iterator<Row> rowIterator = sheet.iterator();

        List<Ticket> tickets = new ArrayList<>();

        // Ignorar a primeira linha (cabeçalhos)
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        // Iterar pelas linhas do arquivo Excel
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Ticket ticket = new Ticket();

            // Preencher os campos do Ticket a partir das células da linha
            ticket.setStatusTicket(getCellValue(row, 0));
            ticket.setDescricaoTicket(getCellValue(row, 1));
            ticket.setTipoAssociacao(getCellValue(row, 2));
            ticket.setIdentificacaoAssociacao(getCellValue(row, 3));
            ticket.setDescricaoAssociacao(getCellValue(row, 4));
            ticket.setNomeSolicitante(getCellValue(row, 5));
            ticket.setNomeAvaliadorTecnico(getCellValue(row, 6));
            ticket.setTipoDesenvolvedor(getCellValue(row, 7));
            ticket.setNomeDesenvolvedor(getCellValue(row, 8));
            ticket.setPrioridade(getCellValue(row, 9));
            ticket.setMotivoSolicitacao(getCellValue(row, 10));
            ticket.setEquipeTrabalho(getCellValue(row, 11));
            ticket.setModulo(getCellValue(row, 12));
            ticket.setEtapa(getCellValue(row, 13));
            ticket.setDataCriacaoTicket(parseLocalDateTime(getCellValue(row, 14)));
            ticket.setDataEncerramentoTicket(parseLocalDateTime(getCellValue(row, 15)));
            ticket.setStatusDocumento(getCellValue(row, 16));
            ticket.setTipoSolicitacao(getCellValue(row, 17));
            ticket.setDocumentoReprovado(getCellValue(row, 18));
            ticket.setMotivoReprovacao(getCellValue(row, 19));
            ticket.setComplexidade(getCellValue(row, 20));
            ticket.setVolumeTrabalho(getCellValue(row, 21));
            ticket.setTotalEsforcoPrevistoHs(parseInteger(getCellValue(row, 22)));
            ticket.setPrazoEntregaDesenvolvedor(parseLocalDate(getCellValue(row, 23)));
            ticket.setTotalEsforcoAdicionalHs(parseInteger(getCellValue(row, 24)));
            ticket.setEsforcoPrevistoMaisAdicionalHs(parseInteger(getCellValue(row, 25)));
            ticket.setEsforcoRealHs(parseInteger(getCellValue(row, 26)));
            ticket.setTerminoRealDesenvolvedor(parseLocalDateTime(getCellValue(row, 27)));
            ticket.setStatusDesenvolvimento(getCellValue(row, 28));
            ticket.setChangeRequests(getCellValue(row, 29));
            ticket.setDataAtual(parseLocalDateTime(getCellValue(row, 30)));
            ticket.setDataTratada(parseLocalDateTime(getCellValue(row, 31)));
            ticket.setDataConvertida(parseLocalDateTime(getCellValue(row, 32)));

            tickets.add(ticket);
        }

        // Salvar os tickets no banco
        ticketRepository.saveAll(tickets);

        workbook.close();
        file.close();
    }

    // Método auxiliar para obter o valor de uma célula
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

    // Converter para LocalDate
    private LocalDate parseLocalDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    // Converter para LocalDateTime
    private LocalDateTime parseLocalDateTime(String value) {
        try {
            return LocalDateTime.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    // Converter para Integer
    private Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}

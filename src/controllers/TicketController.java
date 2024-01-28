package controllers;

import dtos.GenerateTicketRequestDTO;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(GenerateTicketRequestDTO requestDTO) throws Exception {
        return  ticketService.generateTicket(requestDTO.getVehicleNumber(),requestDTO.getVehicleType(), requestDTO.getGateId());
    }
}

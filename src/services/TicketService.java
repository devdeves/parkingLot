package services;

import java.util.Date;

import exceptions.GateNotFoundException;
import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.Gate;
import models.Spot;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;
import repositories.TicketRepository;
import strategies.SpotAssignmentStrategy;


public class TicketService {
    SpotAssignmentStrategy spotAssignmentStrategy;
    GateService gateService;

    public TicketService(SpotAssignmentStrategy spotAssignmentStrategy, GateService gateService, TicketRepository ticketRepository) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.gateService = gateService;
        this.ticketRepository = ticketRepository;
    }

    TicketRepository ticketRepository;
    public Ticket generateTicket(String vehicleNumber , VehicleType vehicleType,int gateId) throws Exception {
//GateRepository gateRepository = new GateRepository();

         //ThisOne way //
        //Gate gate = gateRepository.getGateById(gateId);
        Gate gate = gateService.getGateById(gateId);
        if(gate == null){
            throw new GateNotFoundException();
        }

        Spot spot;
        spot = spotAssignmentStrategy.assignSpot(vehicleType,gate);
        Date entryTime = new Date();
        Ticket ticket = ticketRepository.createTicket(vehicleNumber,spot,entryTime);
        return  ticket;
    }
}

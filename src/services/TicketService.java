package services;

import java.util.Date;

import exceptions.GateNotFoundException;
import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.*;
import repositories.GateRepository;
import repositories.TicketRepository;
import strategies.SpotAssignmentStrategy;


public class TicketService {
    SpotAssignmentStrategy spotAssignmentStrategy;
    GateService gateService;

    VehicleService vehicleService;

    public TicketService(SpotAssignmentStrategy spotAssignmentStrategy, GateService gateService, TicketRepository ticketRepository,VehicleService vehicleService) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.gateService = gateService;
        this.ticketRepository = ticketRepository;
        this.vehicleService = vehicleService;

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
        Vehicle vehicle = vehicleService.insertIfNotExists(vehicleNumber, vehicleType);
        Spot spot;
        spot = spotAssignmentStrategy.assignSpot(vehicle,gate);
        Date entryTime = new Date();
        Ticket ticket = ticketRepository.createTicket(vehicle,spot,entryTime);
        return  ticket;
    }
}

package services;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.Gate;
import models.Spot;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;
import strategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    SpotAssignmentStrategy spotAssignmentStrategy;
    GateService gateService;
    public Ticket generateTicket(String vehicleNumber , VehicleType vehicleType,int gateId) throws Exception {
         GateRepository gateRepository = new GateRepository();

         //ThisOne way //
        //Gate gate = gateRepository.getGateById(gateId);
        Gate gate = gateService.getGateById(gateId);
        Spot spot;
        try {
            spot = spotAssignmentStrategy.assignSpot(vehicleType,gate);
        } catch (Exception e){
            throw e;
        }
        Date entryTime = new Date();
        return  null;
    }
}

package repositories;

import models.BaseModel;
import models.Spot;
import models.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket>map;
    private int idSequence = 1;
    public TicketRepository(){
        map = new HashMap<>();
    }
    public Ticket createTicket(String vehicleNumber, Spot assignedSpot, Date entryTime){
        BaseModel baseModel = new BaseModel(idSequence,new Date(),new Date());
        Ticket ticket = new Ticket(baseModel,vehicleNumber,assignedSpot,entryTime);
        map.put(idSequence,ticket);
        idSequence++;
        return ticket;

        //TOdo do changes in ticket service to create Ticket //
        //Sign-off 3:33 //
    }
}

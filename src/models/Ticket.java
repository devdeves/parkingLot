package models;

import java.util.Date;

public class Ticket {
    private BaseModel baseModel;
    private String vehicleNumber;
    private Spot assignedSpot;

    public BaseModel getBaseModel() {
        return baseModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Spot getAssignedSpot() {
        return assignedSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Ticket(BaseModel baseModel , String vehicleNumber, Spot assignedSpot, Date entryTime) {
        this.baseModel = baseModel;
        this.vehicleNumber = vehicleNumber;
        this.assignedSpot = assignedSpot;
        this.entryTime = entryTime;
    }

    private Date entryTime;
}

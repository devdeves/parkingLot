package dtos;

import models.VehicleType;

public class GenerateTicketRequestDTO {
    int gateId;
    VehicleType vehicleType;

    public int getGateId() {
        return gateId;
    }

    public GenerateTicketRequestDTO(int gateId, VehicleType vehicleType, String vehicleNumber) {
        this.gateId = gateId;
        this.vehicleType = vehicleType;
        VehicleNumber = vehicleNumber;
    }

    String VehicleNumber ;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

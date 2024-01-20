package models;

public class Vehicle {
    private BaseModel baseModel;
    private VehicleType vehicleType;
    private String vehicleNumber;

    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
}

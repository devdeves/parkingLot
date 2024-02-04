package models;

public class Vehicle {
    private BaseModel baseModel;
    private VehicleType vehicleType;

    public Vehicle(BaseModel baseModel, VehicleType vehicleType, String vehicleNumber) {
        this.baseModel = baseModel;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    private String vehicleNumber;

    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
}

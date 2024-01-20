package models;

public class Spot {
    private BaseModel baseModel;
    private String spotName;
    private SpotStatus status;
    private Vehicle vehicle;
    private VehicleType supportedVehicleType;

    public String getSpotName() {
        return spotName;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }
}

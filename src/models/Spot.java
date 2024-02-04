package models;

public class Spot {
    private BaseModel baseModel;
    private String spotName;
    private SpotStatus status;
    private Vehicle vehicle;

    public Spot(BaseModel baseModel, String spotName, VehicleType supportedVehicleType) {
        this.baseModel = baseModel;
        this.spotName = spotName;
        this.supportedVehicleType = supportedVehicleType;
        this.status = SpotStatus.EMPTY;

    }

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

    public void  asignSpot(Vehicle vehicle){
        this.vehicle = vehicle;
        this.status = SpotStatus.OCCUPIED;

    }
}

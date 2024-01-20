package strategies;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import models.Gate;
import models.Spot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    public Spot assignSpot(VehicleType vehicleType, Gate gate) throws NoParkingSpotAvilableFoundForVehicle;
}

package strategies;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.Gate;
import models.Spot;
import models.Vehicle;
import models.VehicleType;

public interface SpotAssignmentStrategy {

    Spot assignSpot(VehicleType vehicleType, Gate gate) throws Exception;
}

package strategies;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.Gate;
import models.Spot;
import models.Vehicle;
import models.VehicleType;

public interface SpotAssignmentStrategy {

    Spot assignSpot(Vehicle vehicle, Gate gate) throws Exception;
}

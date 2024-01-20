package strategies;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import models.*;
import repositories.ParkingLotRespository;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotRespository respository;
    @Override
    public Spot assignSpot(VehicleType vehicleType, Gate gate) throws NoParkingSpotAvilableFoundForVehicle {
        ParkingLot parkingLot = respository.getParkingLotByGateId(gate.getBaseModel().getId());
        if (parkingLot != null) {
            for (Floor floor :parkingLot.getFloors()){
                for (Spot spot :floor.getSpots()){
                    if(spot.getStatus().equals(SpotStatus.EMPTY) && spot.getSupportedVehicleType().equals(vehicleType)){
                        return spot;
                    }
                }
            }
        }
        throw new NoParkingSpotAvilableFoundForVehicle("NO SLOT IS AVILABLE FOR" + vehicleType.name());
    }
    //TOdo to contine from here 1:19 ...TIME & DATE sign-of 3:20  21-01-24 //
}

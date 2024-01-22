package strategies;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.*;
import repositories.ParkingLotRespository;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotRespository respository;
    @Override
    public Spot assignSpot(VehicleType vehicleType, Gate gate) throws NoParkingSpotAvilableFoundForVehicle, ParkingLotDoesntExists {
        ParkingLot parkingLot = respository.getParkingLotByGateId(gate.getBaseModel().getId());
            if (parkingLot != null) {
                return getAvilableSpot(parkingLot,vehicleType);
            }
        throw new ParkingLotDoesntExists();
    }

   private Spot getAvilableSpot(ParkingLot parkingLot ,VehicleType vehicleType) throws NoParkingSpotAvilableFoundForVehicle {
       for (Floor floor :parkingLot.getFloors()){
           for (Spot spot :floor.getSpots()){
               if(spot.getStatus().equals(SpotStatus.EMPTY) && spot.getSupportedVehicleType().equals(vehicleType)){
                   return spot;
               }
           }
       }
       throw new NoParkingSpotAvilableFoundForVehicle("NO SLOT IS AVILABLE FOR" + vehicleType.name());
   }
}

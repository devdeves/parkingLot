package strategies;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import exceptions.ParkingLotDoesntExists;
import models.*;
import repositories.ParkingLotRespository;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotRespository respository;

    public NearestSpotAssignmentStrategy(ParkingLotRespository respository) {
        this.respository = respository;
    }

    @Override
    public Spot assignSpot(Vehicle vehicle, Gate gate) throws NoParkingSpotAvilableFoundForVehicle, ParkingLotDoesntExists {
        ParkingLot parkingLot = respository.getParkingLotByGateId(gate.getBaseModel().getId());
            if (parkingLot != null) {
                Spot availableSpot =  getAvilableSpot(parkingLot,vehicle.getVehicleType());
                availableSpot.asignSpot(vehicle);
                return availableSpot;
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

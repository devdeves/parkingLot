package repositories;

import exceptions.NoParkingSpotAvilableFoundForVehicle;
import models.*;
import strategies.SpotAssignmentStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRespository {
    private Map<Integer , ParkingLot>maps ;

    public ParkingLotRespository(Map<Integer, ParkingLot> maps) {
        this.maps = maps;
    }

    public ParkingLotRespository() {
        maps = new HashMap<>();
    }

    public ParkingLot getParkingLotByGateId(int gateId){
        for(Map.Entry<Integer ,ParkingLot>entry : maps.entrySet()){
            ParkingLot parkingLot = entry.getValue();
            for (Gate entryGate :parkingLot.getEntryGates()){
                if(entryGate.getBaseModel().getId() == gateId){
                    return parkingLot;
                }
            }
        }
        return null;
    }
}

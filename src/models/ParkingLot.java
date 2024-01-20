package models;

import java.util.List;

public class ParkingLot {
    private BaseModel baseModel;
    private List<Floor> floors;

    private List<EntryGate>entryGates;
    private List<ExitGate>exitGates;

    public BaseModel getBaseModel() {
        return baseModel;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }

}

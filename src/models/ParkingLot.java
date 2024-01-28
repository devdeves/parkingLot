package models;

import java.util.List;

public class ParkingLot {
    private BaseModel baseModel;
    private List<Floor> floors;

    public ParkingLot(BaseModel baseModel, List<Floor> floors, List<Gate> entryGates) {
        this.baseModel = baseModel;
        this.floors = floors;
        this.entryGates = entryGates;
     //   this.exitGates = exitGates;
    }

    private List<Gate>entryGates;
    private List<Gate>exitGates;

    public BaseModel getBaseModel() {
        return baseModel;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

}

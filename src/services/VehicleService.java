package services;

import models.Vehicle;
import models.VehicleType;
import repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByNumber(String vehicleNumber){
        return vehicleRepository.getVehicleByNumber(vehicleNumber);
    }

    public Vehicle insertVehicle(String vehicleNumber, VehicleType vehicleType){
        return vehicleRepository.insertVehicle(vehicleNumber, vehicleType);
    }

    public Vehicle insertIfNotExists(String vehicleNumber, VehicleType vehicleType){
        Vehicle vehicleByNumber = getVehicleByNumber(vehicleNumber);
        if(vehicleByNumber == null){
            return insertVehicle(vehicleNumber, vehicleType);
        }
        return vehicleByNumber;
    }
}

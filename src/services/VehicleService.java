package services;

import models.Vehicle;
import repositories.VehicleRepository;

public class VehicleService {
private VehicleRepository vehicleRepository;
public VehicleService(VehicleRepository vehicleRepository){
    this.vehicleRepository = vehicleRepository;
}
public Vehicle getVehicleByNumber(String vehicleNumber){
    return vehicleRepository.getVechicleByNumber(vehicleNumber);
}
}

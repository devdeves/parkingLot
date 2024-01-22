package services;

import models.Gate;
import repositories.GateRepository;

public class GateService {
    GateRepository gateRepository;
    public Gate getGateById(int gateId){
            return  gateRepository.getGateById(gateId);
    }
}

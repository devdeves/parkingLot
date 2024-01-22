package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer , Gate>map;
    public GateRepository(){
        map = new HashMap<>();
    }
    public Gate getGateById(int gateId){
        return  map.get(gateId);
    }
}

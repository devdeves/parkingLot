import controllers.TicketController;
import dtos.GenerateTicketRequestDTO;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRespository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.GateService;
import services.TicketService;
import services.VehicleService;
import strategies.NearestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Spot spot1 = new Spot(new BaseModel(1), "D1",VehicleType.CAR);
        Spot spot2 = new Spot(new BaseModel(12), "D2",VehicleType.CAR);
        Spot spot3 = new Spot(new BaseModel(13), "D3",VehicleType.CAR);
        Spot spot4 = new Spot(new BaseModel(14), "D3",VehicleType.CAR);

        Floor floor1 = new Floor(new BaseModel(1), Arrays.asList(spot1,spot2),1);
        Floor floor2 = new Floor(new BaseModel(2), Arrays.asList(spot3,spot4),2);

        Gate gate1 = new Gate(new BaseModel(1),"G1");
        Gate gate2 = new Gate(new BaseModel(2),"G2");
        Map<Integer, Gate> gateMap = new HashMap<Integer, Gate>(){{
            put(gate1.getBaseModel().getId(), gate1);
            put(gate2.getBaseModel().getId(), gate2);
        }};


        ParkingLot parkingLot = new ParkingLot(new BaseModel(4),Arrays.asList(floor1,floor2),Arrays.asList(gate1,gate2));
        Map<Integer, ParkingLot> parkingLotMap = new HashMap<Integer, ParkingLot>(){{
            put(parkingLot.getBaseModel().getId(), parkingLot);
        }};


        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository(gateMap);
        ParkingLotRespository parkingLotRespository = new ParkingLotRespository(parkingLotMap);

        GateService gateService = new GateService(gateRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new NearestSpotAssignmentStrategy(parkingLotRespository);

        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);

        TicketService ticketService = new TicketService(spotAssignmentStrategy,gateService,ticketRepository, vehicleService);
        TicketController ticketController = new TicketController(ticketService);
        GenerateTicketRequestDTO requestDTO = new GenerateTicketRequestDTO(1, VehicleType.CAR,"123");
        Ticket ticket = ticketController.generateTicket(requestDTO);

        System.out.println(ticket);
    }
}
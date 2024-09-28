package com.scaler.parking_lot.services;

import com.scaler.parking_lot.exceptions.InvalidGateException;
import com.scaler.parking_lot.exceptions.InvalidParkingLotException;
import com.scaler.parking_lot.exceptions.ParkingSpotNotAvailableException;
import com.scaler.parking_lot.models.*;
import com.scaler.parking_lot.respositories.GateRepository;
import com.scaler.parking_lot.respositories.ParkingLotRepository;
import com.scaler.parking_lot.respositories.TicketRepository;
import com.scaler.parking_lot.respositories.VehicleRepository;

import java.util.Optional;

public class TicketServiceImpl implements TicketService{
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    public TicketServiceImpl(GateRepository gateRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleType) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException {
        Optional<Gate> optionalGate = gateRepository.findById(gateId);
        if(optionalGate.isEmpty() || optionalGate.get().getType().equals(GateType.EXIT))
            throw new InvalidGateException("Invalid Gate Id");
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotByGateId(gateId);
        if(optionalParkingLot.isEmpty())
            throw new InvalidParkingLotException("Parking Lot is Unavailable");

        for(ParkingFloor floor : optionalParkingLot.get().getParkingFloors()) {

        }
        Ticket ticket = new Ticket();
        return null;
    }
}


























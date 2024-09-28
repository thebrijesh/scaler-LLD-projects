package com.scaler.parking_lot.respositories;

import com.scaler.parking_lot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepositoryImpl implements VehicleRepository{
    Map<String, Vehicle> map = new HashMap<>();
    @Override
    public Optional<Vehicle> getVehicleByRegistrationNumber(String registrationNumber) {
        return Optional.ofNullable(map.get(registrationNumber));
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        map.put(vehicle.getRegistrationNumber(), vehicle);
        return vehicle;
    }
}

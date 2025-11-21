package com.brij.vehicle.vehicle_manager.service;

import com.brij.vehicle.vehicle_manager.dto.VehicleRequest;
import com.brij.vehicle.vehicle_manager.entity.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {
    Vehicle createVehicle(VehicleRequest request);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicle(UUID id);
    Vehicle updateVehicle(UUID id, VehicleRequest request);
    void deleteVehicle(UUID id);
}

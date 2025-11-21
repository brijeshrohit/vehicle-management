package com.brij.vehicle.vehicle_manager.service;

import com.brij.vehicle.vehicle_manager.entity.FuelEntry;

import java.util.List;

public interface FuelService {
    FuelEntry addFuelEntry(FuelEntry entry);
    List<FuelEntry> getFuelEntriesForVehicle(String vehicleId);
}

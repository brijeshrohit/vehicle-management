package com.brij.vehicle.vehicle_manager.service;

import com.brij.vehicle.vehicle_manager.entity.MaintenanceEntry;

import java.util.List;

public interface MaintenanceService {
    MaintenanceEntry addMaintenance(MaintenanceEntry entry);
    List<MaintenanceEntry> getMaintenanceForVehicle(String vehicleId);
}

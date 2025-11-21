package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.MaintenanceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRepository extends JpaRepository<MaintenanceEntry, String> {
    List<MaintenanceEntry> findByVehicleIdOrderByNextDueDateAsc(String vehicleId);
}


package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.MaintenanceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<MaintenanceEntry, UUID> {
    List<MaintenanceEntry> findByVehicleIdOrderByDueDateAsc(UUID vehicleId);
}


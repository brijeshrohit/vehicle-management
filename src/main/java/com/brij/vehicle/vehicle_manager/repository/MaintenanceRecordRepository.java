package com.brij.vehicle.vehicle_manager.repository;

import org.hibernate.validator.constraints.UUID;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, UUID> {
    List<MaintenanceRecord> findByVehicleIdOrderByMaintenanceDateAsc(UUID vehicleId);
}
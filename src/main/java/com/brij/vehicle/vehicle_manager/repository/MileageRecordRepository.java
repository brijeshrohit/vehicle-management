package com.brij.vehicle.vehicle_manager.repository;

import org.hibernate.validator.constraints.UUID;

public interface MileageRecordRepository extends JpaRepository<MileageRecord, UUID> {
    List<MileageRecord> findByVehicleIdOrderByRecordedAtAsc(UUID vehicleId);
}

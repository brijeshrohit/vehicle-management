package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.MileageRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MileageRecordRepository extends JpaRepository<MileageRecord, UUID> {
    List<MileageRecord> findByVehicleIdOrderByRecordedAtAsc(UUID vehicleId);
}

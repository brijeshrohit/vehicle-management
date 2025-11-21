package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.FuelEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FuelEntryRepository extends JpaRepository<FuelEntry, UUID> {
    List<FuelEntry> findByVehicleIdOrderByDateDesc(UUID vehicleId);
}

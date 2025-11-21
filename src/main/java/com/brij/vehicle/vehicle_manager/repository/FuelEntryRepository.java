package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.FuelEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelEntryRepository extends JpaRepository<FuelEntry, String> {
    List<FuelEntry> findByVehicleIdOrderByEntryDateDesc(String vehicleId);
}

package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByUserId(String userId);
}
package com.brij.vehicle.vehicle_manager.repository;

import com.brij.vehicle.vehicle_manager.entity.ExpenseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseRecordRepository extends JpaRepository<ExpenseRecord, UUID> {
    List<ExpenseRecord> findByVehicleIdOrderByExpenseDateAsc(UUID vehicleId);
}

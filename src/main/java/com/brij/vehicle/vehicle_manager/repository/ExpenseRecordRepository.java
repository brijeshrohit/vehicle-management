package com.brij.vehicle.vehicle_manager.repository;


import org.hibernate.validator.constraints.UUID;

public interface ExpenseRecordRepository extends JpaRepository<ExpenseRecord, UUID> {
    List<ExpenseRecord> findByVehicleIdOrderByExpenseDateAsc(UUID vehicleId);
}
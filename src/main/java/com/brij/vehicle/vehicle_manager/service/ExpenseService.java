package com.brij.vehicle.vehicle_manager.service;

import com.brij.vehicle.vehicle_manager.dto.ExpenseRecordRequest;
import com.brij.vehicle.vehicle_manager.entity.ExpenseRecord;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    ExpenseRecord addExpense(ExpenseRecordRequest request);
    List<ExpenseRecord> getExpensesForVehicle(UUID vehicleId);
}

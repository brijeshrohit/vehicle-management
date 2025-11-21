package com.brij.vehicle.vehicle_manager.service.impl;

import com.brij.vehicle.vehicle_manager.dto.ExpenseRecordRequest;
import com.brij.vehicle.vehicle_manager.entity.ExpenseRecord;
import com.brij.vehicle.vehicle_manager.entity.Vehicle;
import com.brij.vehicle.vehicle_manager.exception.ResourceNotFound;
import com.brij.vehicle.vehicle_manager.repository.ExpenseRecordRepository;
import com.brij.vehicle.vehicle_manager.repository.VehicleRepository;
import com.brij.vehicle.vehicle_manager.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRecordRepository expenseRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public ExpenseRecord addExpense(ExpenseRecordRequest request) {
        Vehicle vehicle = (Vehicle) vehicleRepository.findById(UUID.fromString(request.getVehicleId()))
                .orElseThrow(() -> new ResourceNotFound("Vehicle", request.getVehicleId()));

        ExpenseRecord record = ExpenseRecord.builder()
                .id(UUID.randomUUID())
                .vehicle(vehicle)
                .expenseType(request.getExpenseType())
                .amount(request.getAmount())
                .expenseDate(request.getExpenseDate())
                .notes(request.getNotes())
                .build();

        return expenseRepository.save(record);
    }

    @Override
    public List<ExpenseRecord> getExpensesForVehicle(UUID vehicleId) {
        return expenseRepository.findByVehicleIdOrderByExpenseDateAsc(vehicleId);
    }
}

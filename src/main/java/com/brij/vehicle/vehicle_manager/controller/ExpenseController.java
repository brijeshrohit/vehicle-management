package com.brij.vehicle.vehicle_manager.controller;

import com.brij.vehicle.vehicle_manager.dto.ExpenseRecordRequest;
import com.brij.vehicle.vehicle_manager.entity.ExpenseRecord;
import com.brij.vehicle.vehicle_manager.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ExpenseRecord addExpense(@Valid @RequestBody ExpenseRecordRequest request) {
        return expenseService.addExpense(request);
    }

    @GetMapping("/{vehicleId}")
    public List<ExpenseRecord> getExpenses(@PathVariable UUID vehicleId) {
        return expenseService.getExpensesForVehicle(vehicleId);
    }
}

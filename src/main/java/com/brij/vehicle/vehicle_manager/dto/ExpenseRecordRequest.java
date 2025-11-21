package com.brij.vehicle.vehicle_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRecordRequest {

    @NotNull
    private String vehicleId;

    @NotBlank
    private String expenseType;

    @NotNull
    private Double amount;

    @NotNull
    private LocalDate expenseDate;

    private String notes;
}

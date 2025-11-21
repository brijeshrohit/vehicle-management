package com.brij.vehicle.vehicle_manager.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuelEntryRequest {

    @NotNull
    private LocalDate date;

    @NotNull
    private Integer odometer;

    @NotNull
    private Double liters;

    @NotNull
    private Double amount;

    private Boolean fullTank = true;
}

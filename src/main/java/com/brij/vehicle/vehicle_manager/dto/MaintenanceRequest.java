package com.brij.vehicle.vehicle_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MaintenanceRequest {

    @NotBlank
    private String title;

    @NotNull
    private LocalDate lastDoneDate;

    @NotNull
    private Integer lastOdometer;

    private LocalDate dueDate;

    private Integer dueOdometer;

    private String notes;
}

package com.brij.vehicle.vehicle_manager.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MileageRecordRequest {

    @NotNull
    private String vehicleId;

    @NotNull
    private Double odometerReading;

    private Double fuelFilled;
    private Double totalCost;
    private Double mileage;

    @NotNull
    private LocalDate recordedAt;
}

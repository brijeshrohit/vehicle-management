package com.brij.vehicle.vehicle_manager.dto;

import com.brij.vehicle.vehicle_manager.util.FuelType;
import com.brij.vehicle.vehicle_manager.util.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleRequest {

    @NotBlank
    private String name;

    @NotNull
    private VehicleType type;

    @NotNull
    private FuelType fuelType;

    private String registrationNo;

    @NotNull
    private Integer odometer;
}

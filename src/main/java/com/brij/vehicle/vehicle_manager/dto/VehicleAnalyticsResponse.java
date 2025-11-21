package com.brij.vehicle.vehicle_manager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleAnalyticsResponse {
    private String vehicleId;
    private Double totalFuelConsumed;
    private Double totalFuelCost;
    private Double totalMaintenanceCost;
    private Double totalOtherExpenses;
    private Double averageMileage;
}

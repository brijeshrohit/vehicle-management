package com.brij.vehicle.vehicle_manager.service;

import com.brij.vehicle.vehicle_manager.dto.VehicleAnalyticsResponse;

import java.util.UUID;

public interface AnalyticsService {
    VehicleAnalyticsResponse getVehicleAnalytics(UUID vehicleId);
}

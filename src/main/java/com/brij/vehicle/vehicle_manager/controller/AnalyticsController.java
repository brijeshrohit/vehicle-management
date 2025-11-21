package com.brij.vehicle.vehicle_manager.controller;

import com.brij.vehicle.vehicle_manager.dto.VehicleAnalyticsResponse;
import com.brij.vehicle.vehicle_manager.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/vehicle/{vehicleId}")
    public VehicleAnalyticsResponse getVehicleAnalytics(@PathVariable UUID vehicleId) {
        return analyticsService.getVehicleAnalytics(vehicleId);
    }
}

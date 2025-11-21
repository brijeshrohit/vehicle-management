package com.brij.vehicle.vehicle_manager.controller;

import com.brij.vehicle.vehicle_manager.entity.MaintenanceEntry;
import com.brij.vehicle.vehicle_manager.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @PostMapping
    public MaintenanceEntry addMaintenance(@RequestBody MaintenanceEntry entry) {
        return maintenanceService.addMaintenance(entry);
    }

    @GetMapping("/{vehicleId}")
    public List<MaintenanceEntry> getMaintenance(@PathVariable String vehicleId) {
        return maintenanceService.getMaintenanceForVehicle(vehicleId);
    }
}

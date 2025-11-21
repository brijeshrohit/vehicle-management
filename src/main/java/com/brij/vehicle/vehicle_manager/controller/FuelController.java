package com.brij.vehicle.vehicle_manager.controller;

import com.brij.vehicle.vehicle_manager.entity.FuelEntry;
import com.brij.vehicle.vehicle_manager.service.FuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel")
@RequiredArgsConstructor
public class FuelController {

    private final FuelService fuelService;

    @PostMapping
    public FuelEntry addFuel(@RequestBody FuelEntry entry) {
        return fuelService.addFuelEntry(entry);
    }

    @GetMapping("/{vehicleId}")
    public List<FuelEntry> getFuelEntries(@PathVariable String vehicleId) {
        return fuelService.getFuelEntriesForVehicle(vehicleId);
    }
}

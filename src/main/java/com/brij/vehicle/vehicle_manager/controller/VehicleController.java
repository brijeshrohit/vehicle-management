package com.brij.vehicle.vehicle_manager.controller;

import com.brij.vehicle.vehicle_manager.dto.VehicleRequest;
import com.brij.vehicle.vehicle_manager.entity.Vehicle;
import com.brij.vehicle.vehicle_manager.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public Vehicle create(@Valid @RequestBody VehicleRequest request) {
        return vehicleService.createVehicle(request);
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle get(@PathVariable UUID id) {
        return vehicleService.getVehicle(id);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable UUID id, @Valid @RequestBody VehicleRequest request) {
        return vehicleService.updateVehicle(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        vehicleService.deleteVehicle(id);
    }
}

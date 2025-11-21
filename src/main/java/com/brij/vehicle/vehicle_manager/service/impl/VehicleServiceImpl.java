package com.brij.vehicle.vehicle_manager.service.impl;

import com.brij.vehicle.vehicle_manager.dto.VehicleRequest;
import com.brij.vehicle.vehicle_manager.entity.Vehicle;
import com.brij.vehicle.vehicle_manager.exception.ResourceNotFound;
import com.brij.vehicle.vehicle_manager.repository.VehicleRepository;
import com.brij.vehicle.vehicle_manager.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle createVehicle(VehicleRequest request) {
        Vehicle vehicle = Vehicle.builder()
                .name(request.getName())
                .type(request.getType())
                .fuelType(request.getFuelType())
                .registrationNo(request.getRegistrationNo())
                .odometer(request.getOdometer())
                .build();
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicle(UUID id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Vehicle", id));
    }

    @Override
    public Vehicle updateVehicle(UUID id, VehicleRequest request) {
        Vehicle vehicle = getVehicle(id);
        vehicle.setName(request.getName());
        vehicle.setType(request.getType());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setRegistrationNo(request.getRegistrationNo());
        vehicle.setOdometer(request.getOdometer());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(UUID id) {
        vehicleRepository.delete(getVehicle(id));
    }
}

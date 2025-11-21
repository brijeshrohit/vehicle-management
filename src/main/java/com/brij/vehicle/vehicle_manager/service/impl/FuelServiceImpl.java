package com.brij.vehicle.vehicle_manager.service.impl;

import com.brij.vehicle.vehicle_manager.entity.FuelEntry;
import com.brij.vehicle.vehicle_manager.repository.FuelEntryRepository;
import com.brij.vehicle.vehicle_manager.service.FuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FuelServiceImpl implements FuelService {

    private final FuelEntryRepository fuelEntryRepository;

    @Override
    public FuelEntry addFuelEntry(FuelEntry entry) {
        entry.setId(UUID.randomUUID().toString());
        return fuelEntryRepository.save(entry);
    }

    @Override
    public List<FuelEntry> getFuelEntriesForVehicle(String vehicleId) {
        return fuelEntryRepository.findByVehicleIdOrderByEntryDateDesc(vehicleId);
    }
}

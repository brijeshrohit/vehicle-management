package com.brij.vehicle.vehicle_manager.service.impl;

import com.brij.vehicle.vehicle_manager.entity.MaintenanceEntry;
import com.brij.vehicle.vehicle_manager.repository.MaintenanceRepository;
import com.brij.vehicle.vehicle_manager.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public MaintenanceEntry addMaintenance(MaintenanceEntry entry) {
        entry.setId(UUID.randomUUID().toString());
        return maintenanceRepository.save(entry);
    }

    @Override
    public List<MaintenanceEntry> getMaintenanceForVehicle(String vehicleId) {
        return maintenanceRepository.findByVehicleIdOrderByNextDueDateAsc(vehicleId);
    }
}

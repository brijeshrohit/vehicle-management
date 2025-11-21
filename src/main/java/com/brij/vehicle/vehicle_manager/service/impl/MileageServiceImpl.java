package com.brij.vehicle.vehicle_manager.service.impl;

import com.brij.vehicle.vehicle_manager.dto.MileageRecordRequest;
import com.brij.vehicle.vehicle_manager.entity.MileageRecord;
import com.brij.vehicle.vehicle_manager.entity.Vehicle;
import com.brij.vehicle.vehicle_manager.exception.ResourceNotFound;
import com.brij.vehicle.vehicle_manager.repository.MileageRecordRepository;
import com.brij.vehicle.vehicle_manager.repository.VehicleRepository;
import com.brij.vehicle.vehicle_manager.service.MileageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MileageServiceImpl implements MileageService {

    private final MileageRecordRepository mileageRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public MileageRecord addMileageRecord(MileageRecordRequest request) {
        Vehicle vehicle = (Vehicle) vehicleRepository.findById(UUID.fromString(request.getVehicleId()))
                .orElseThrow(() -> new ResourceNotFound("Vehicle", request.getVehicleId()));

        MileageRecord record = MileageRecord.builder()
                .id(UUID.randomUUID())
                .vehicle(vehicle)
                .odometerReading(request.getOdometerReading())
                .fuelFilled(request.getFuelFilled())
                .totalCost(request.getTotalCost())
                .mileage(request.getMileage())
                .recordedAt(request.getRecordedAt())
                .build();

        return mileageRepository.save(record);
    }

    @Override
    public List<MileageRecord> getMileageRecordsForVehicle(UUID vehicleId) {
        return mileageRepository.findByVehicleIdOrderByRecordedAtAsc(UUID.fromString(vehicleId.toString()));
    }
}

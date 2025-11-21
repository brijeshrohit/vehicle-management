package com.brij.vehicle.vehicle_manager.service;

import com.brij.vehicle.vehicle_manager.dto.MileageRecordRequest;
import com.brij.vehicle.vehicle_manager.entity.MileageRecord;

import java.util.List;
import java.util.UUID;

public interface MileageService {
    MileageRecord addMileageRecord(MileageRecordRequest request);
    List<MileageRecord> getMileageRecordsForVehicle(UUID vehicleId);
}

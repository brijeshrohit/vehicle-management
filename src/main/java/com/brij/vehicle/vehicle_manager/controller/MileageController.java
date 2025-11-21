package com.brij.vehicle.vehicle_manager.controller;

import com.brij.vehicle.vehicle_manager.dto.MileageRecordRequest;
import com.brij.vehicle.vehicle_manager.entity.MileageRecord;
import com.brij.vehicle.vehicle_manager.service.MileageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/mileage")
@RequiredArgsConstructor
public class MileageController {

    private final MileageService mileageService;

    @PostMapping
    public MileageRecord addMileage(@Valid @RequestBody MileageRecordRequest request) {
        return mileageService.addMileageRecord(request);
    }

    @GetMapping("/{vehicleId}")
    public List<MileageRecord> getMileageRecords(@PathVariable UUID vehicleId) {
        return mileageService.getMileageRecordsForVehicle(vehicleId);
    }
}

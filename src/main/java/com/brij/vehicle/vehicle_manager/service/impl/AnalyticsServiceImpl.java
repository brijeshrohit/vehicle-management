package com.brij.vehicle.vehicle_manager.service.impl;

import com.brij.vehicle.vehicle_manager.dto.VehicleAnalyticsResponse;
import com.brij.vehicle.vehicle_manager.entity.ExpenseRecord;
import com.brij.vehicle.vehicle_manager.entity.FuelEntry;
import com.brij.vehicle.vehicle_manager.entity.MaintenanceEntry;
import com.brij.vehicle.vehicle_manager.entity.MileageRecord;
import com.brij.vehicle.vehicle_manager.exception.ResourceNotFound;
import com.brij.vehicle.vehicle_manager.repository.ExpenseRecordRepository;
import com.brij.vehicle.vehicle_manager.repository.FuelEntryRepository;
import com.brij.vehicle.vehicle_manager.repository.MaintenanceRepository;
import com.brij.vehicle.vehicle_manager.repository.MileageRecordRepository;
import com.brij.vehicle.vehicle_manager.repository.VehicleRepository;
import com.brij.vehicle.vehicle_manager.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final FuelEntryRepository fuelEntryRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final ExpenseRecordRepository expenseRecordRepository;
    private final MileageRecordRepository mileageRecordRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleAnalyticsResponse getVehicleAnalytics(UUID vehicleId) {
        // Ensure vehicle exists
        vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFound("Vehicle", vehicleId));

        // Fuel
        List<FuelEntry> fuelEntries = fuelEntryRepository.findByVehicleIdOrderByEntryDateDesc(vehicleId.toString());
        double totalFuel = fuelEntries.stream().mapToDouble(FuelEntry::getLiters).sum();
        double totalFuelCost = fuelEntries.stream().mapToDouble(FuelEntry::getAmount).sum();

        // Maintenance
        List<MaintenanceEntry> maintenanceEntries = maintenanceRepository.findByVehicleIdOrderByNextDueDateAsc(vehicleId.toString());
        double totalMaintenanceCost = maintenanceEntries.stream()
                .filter(m -> m.getCost() != null)
                .mapToDouble(MaintenanceEntry::getCost)
                .sum();

        // Expenses
        List<ExpenseRecord> expenseRecords = expenseRecordRepository.findByVehicleIdOrderByExpenseDateAsc(vehicleId);
        double totalOtherExpenses = expenseRecords.stream()
                .mapToDouble(ExpenseRecord::getAmount)
                .sum();

        // Average Mileage
        List<MileageRecord> mileageRecords = mileageRecordRepository.findByVehicleIdOrderByRecordedAtAsc(vehicleId);
        double averageMileage = mileageRecords.stream()
                .filter(m -> m.getMileage() != null)
                .mapToDouble(MileageRecord::getMileage)
                .average()
                .orElse(0.0);

        return VehicleAnalyticsResponse.builder()
                .vehicleId(vehicleId.toString())
                .totalFuelConsumed(totalFuel)
                .totalFuelCost(totalFuelCost)
                .totalMaintenanceCost(totalMaintenanceCost)
                .totalOtherExpenses(totalOtherExpenses)
                .averageMileage(averageMileage)
                .build();
    }
}

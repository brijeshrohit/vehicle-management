package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "mileage_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MileageRecord {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "odometer_reading", nullable = false)
    private Double odometerReading;

    @Column(name = "fuel_filled")
    private Double fuelFilled;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "mileage")
    private Double mileage;

    @Column(name = "recorded_at")
    private LocalDate recordedAt;
}

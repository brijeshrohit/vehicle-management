package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "fuel_entries", indexes = {
        @Index(name = "idx_fuel_vehicle_date", columnList = "vehicle_id, entry_date"),
        @Index(name = "idx_fuel_vehicle_odometer", columnList = "vehicle_id, odometer")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class FuelEntry extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "vehicle_id", length = 36, nullable = false)
    private String vehicleId;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(nullable = false)
    private Integer odometer;

    @Column(nullable = false, precision = 8, scale = 3)
    private Double liters;

    @Column(nullable = false, precision = 12, scale = 2)
    private Double amount;

    @Column(name = "fuel_price_per_liter", precision = 10, scale = 4)
    private Double fuelPricePerLiter;

    @Column(name = "full_tank", nullable = false)
    private boolean fullTank;

    @Column(length = 500)
    private String notes;
}

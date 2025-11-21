package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "expenses", indexes = {@Index(name = "idx_expense_user_date", columnList = "user_id, date")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "vehicle_id", length = 36)
    private String vehicleId;

    @Column(name = "fuel_entry_id", length = 36)
    private String fuelEntryId;

    @Column(name = "maintenance_entry_id", length = 36)
    private String maintenanceEntryId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 64)
    private String category;

    @Column(nullable = false, precision = 12, scale = 2)
    private Double amount;

    @Column(length = 1000)
    private String notes;
}

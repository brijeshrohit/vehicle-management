package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance_entries", indexes = {
        @Index(name = "idx_maint_vehicle_due", columnList = "vehicle_id, next_due_date"),
        @Index(name = "idx_maint_vehicle_odometer", columnList = "vehicle_id, next_due_odometer")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceEntry extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "vehicle_id", length = 36, nullable = false)
    private String vehicleId;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "last_done_date", nullable = false)
    private LocalDate lastDoneDate;

    @Column(name = "last_done_odometer", nullable = false)
    private Integer lastDoneOdometer;

    @Column(name = "next_due_date")
    private LocalDate nextDueDate;

    @Column(name = "next_due_odometer")
    private Integer nextDueOdometer;

    @Column(precision = 12, scale = 2)
    private Double cost;

    @Column(length = 200)
    private String vendor;

    @Column(length = 1000)
    private String notes;
}

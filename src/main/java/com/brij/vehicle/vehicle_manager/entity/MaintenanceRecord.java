package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "maintenance_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceRecord {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "maintenance_type", nullable = false)
    private String maintenanceType;

    @Column(name = "description")
    private String description;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "maintenance_date")
    private LocalDate maintenanceDate;

    @Column(name = "next_due_date")
    private LocalDate nextDueDate;
}

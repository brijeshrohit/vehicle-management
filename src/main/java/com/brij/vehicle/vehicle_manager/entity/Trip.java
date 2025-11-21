package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "trips", indexes = {@Index(name = "idx_trip_vehicle_time", columnList = "vehicle_id, start_time")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "vehicle_id", length = 36, nullable = false)
    private String vehicleId;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "start_time", nullable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @Column(name = "start_odometer", nullable = false)
    private Integer startOdometer;

    @Column(name = "end_odometer")
    private Integer endOdometer;

    @Column(name = "distance_km", precision = 10, scale = 3)
    private Double distanceKm;

    @Column(length = 255)
    private String purpose;

    @Column(length = 1000)
    private String notes;
}

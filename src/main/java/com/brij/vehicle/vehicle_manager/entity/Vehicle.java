package com.brij.vehicle.vehicle_manager.entity;

import com.brij.vehicle.vehicle_manager.util.FuelType;
import com.brij.vehicle.vehicle_manager.util.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles", indexes = {
        @Index(name = "idx_vehicle_user", columnList = "user_id"),
        @Index(name = "idx_vehicle_user_default", columnList = "user_id, default_vehicle")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicle extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(nullable = false, length = 150)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private VehicleType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false, length = 16)
    private FuelType fuelType;

    @Column(name = "registration_no", length = 50)
    private String registrationNo;

    @Column(nullable = false)
    private Integer odometer;

    @Column(name = "default_vehicle", nullable = false)
    private boolean defaultVehicle;
}


package com.brij.vehicle.vehicle_manager.entity;

import com.brij.vehicle.vehicle_manager.util.FuelType;
import com.brij.vehicle.vehicle_manager.util.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String registrationNo;

    private Integer odometer;
}

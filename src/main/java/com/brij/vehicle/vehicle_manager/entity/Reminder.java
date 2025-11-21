package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "reminders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reminder extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "user_id", length = 36, nullable = false)
    private String userId;

    @Column(name = "vehicle_id", length = 36)
    private String vehicleId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "remind_at", nullable = false)
    private OffsetDateTime remindAt;

    @Column(name = "repeat_interval", length = 64)
    private String repeatInterval;

    @Column(columnDefinition = "json")
    private String payload; // flexible JSON string
}

package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;
}

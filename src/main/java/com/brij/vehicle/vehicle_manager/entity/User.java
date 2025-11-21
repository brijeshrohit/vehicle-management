package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_user_email", columnList = "email")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class User extends BaseEntity {

    @Id
    @Column(length = 36)
    private String id; // UUID string

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(length = 150)
    private String name;

    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    // future: roles, settings, preferences
}

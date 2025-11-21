package com.brij.vehicle.vehicle_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "expense_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseRecord {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "expense_type")
    private String expenseType;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "notes")
    private String notes;
}

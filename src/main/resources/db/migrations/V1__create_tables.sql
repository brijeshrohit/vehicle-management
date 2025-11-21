-- VEHICLE TABLE
CREATE TABLE vehicles (
    id UUID PRIMARY KEY,
    vehicle_name VARCHAR(100) NOT NULL,
    make VARCHAR(100),
    model VARCHAR(100),
    registration_number VARCHAR(50) UNIQUE NOT NULL,
    purchase_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- MILEAGE RECORDS TABLE
CREATE TABLE mileage_records (
    id UUID PRIMARY KEY,
    vehicle_id UUID NOT NULL,
    odometer_reading DECIMAL(10,2) NOT NULL,
    fuel_filled DECIMAL(10,2),
    total_cost DECIMAL(10,2),
    mileage DECIMAL(10,2),
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_mileage_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

-- MAINTENANCE RECORDS TABLE
CREATE TABLE maintenance_records (
    id UUID PRIMARY KEY,
    vehicle_id UUID NOT NULL,
    maintenance_type VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    cost DECIMAL(10,2) NOT NULL,
    maintenance_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    next_due_date DATE,
    CONSTRAINT fk_maintenance_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

-- EXPENSE RECORDS TABLE
CREATE TABLE expense_records (
    id UUID PRIMARY KEY,
    vehicle_id UUID NOT NULL,
    expense_type VARCHAR(100),
    amount DECIMAL(10,2) NOT NULL,
    expense_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notes VARCHAR(500),
    CONSTRAINT fk_expense_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

-- IMPORTANT INDEXES
CREATE INDEX idx_vehicle_regno ON vehicles(registration_number);
CREATE INDEX idx_mileage_vehicle ON mileage_records(vehicle_id);
CREATE INDEX idx_maintenance_vehicle ON maintenance_records(vehicle_id);
CREATE INDEX idx_expense_vehicle ON expense_records(vehicle_id);

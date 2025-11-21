-- Insert sample mileage records for the first vehicle

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 770, 8.801534036, 918, NULL, DATE '2024-04-05'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 1048, 9.587727709, 1000, 29.02, DATE '2024-04-20'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 1217, 5.752636625, 600, 29.37, DATE '2024-04-27'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 1490, 9.587727709, 1000, 28.48, DATE '2024-05-05'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 1780, 10.01930502, 1038, 28.94, DATE '2024-05-21'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 2078, 9.652509653, 1000, 30.86, DATE '2024-06-08'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 2362, 9.670849421, 1001.9, 29.37, DATE '2024-06-20'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 2615, 10.13513514, 1050, 24.98, DATE '2024-07-21'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 2828, 9.459459459, 980, 22.53, DATE '2024-07-26'
FROM vehicles v LIMIT 1;

INSERT INTO mileage_records (id, vehicle_id, odometer_reading, fuel_filled, total_cost, mileage, recorded_at)
SELECT RANDOM_UUID(), v.id, 3132, 10.30888031, 1068, 29.50, DATE '2024-08-24'
FROM vehicles v LIMIT 1;

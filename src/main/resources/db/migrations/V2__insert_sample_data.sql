-- Insert a default user
INSERT INTO users (id, email, name, password_hash)
VALUES (RANDOM_UUID(), 'user@example.com', 'Test User', 'passwordhashplaceholder');

-- Insert a sample vehicle for the user
INSERT INTO vehicles (id, vehicle_name, make, model, registration_number, purchase_date)
SELECT RANDOM_UUID(), 'My Bike', 'Honda', 'Unicorn', 'GJ01AB1234', DATE '2020-01-15'
FROM users u
WHERE u.email = 'user@example.com'
LIMIT 1;

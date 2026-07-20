USE airport_db;

DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS aircrafts;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(255),
    mileage INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE aircrafts (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    seats INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE flights (
    id INT NOT NULL AUTO_INCREMENT,
    number VARCHAR(255) NOT NULL,
    mileage INT NOT NULL,
    aircraft_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (aircraft_id) REFERENCES aircrafts(id)
);

CREATE TABLE bookings (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    flight_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (flight_id) REFERENCES flights(id)
);

INSERT INTO customers (id, name, status, mileage) VALUES
    (1, 'Agustine Riviera', 'Silver', 115235),
    (2, 'Alaina Sepulvida', NULL, 6008),
    (3, 'Tom Jones', 'Gold', 205767),
    (4, 'Sam Rio', NULL, 2653),
    (5, 'Jessica James', 'Silver', 127656),
    (6, 'Ana Janco', 'Silver', 136773),
    (7, 'Jennifer Cortez', 'Gold', 300582),
    (8, 'Christian Janco', 'Silver', 14642);

INSERT INTO aircrafts (id, name, seats) VALUES
    (1, 'Boeing 747', 400),
    (2, 'Airbus A330', 236),
    (3, 'Boeing 777', 264);

INSERT INTO flights (id, number, mileage, aircraft_id) VALUES
    (1, 'DL143', 135, 1),
    (2, 'DL122', 4370,2),
    (3, 'DL53', 2078, 3),
    (4, 'DL222', 1765	, 3),
    (5, 'DL37', 531, 1);

INSERT INTO bookings (id, customer_id, flight_id) VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 2),
    (4, 1, 1),
    (5, 3, 2),
    (6, 3, 3),
    (7, 1, 1),
    (8, 4, 1),
    (9, 1, 1),
    (10, 3, 4),
    (11, 5, 1),
    (12, 4, 1),
    (13, 6, 4),
    (14, 7, 4),
    (15, 5, 2),
    (16, 4, 5),
    (17, 8, 4);

SELECT COUNT(DISTINCT number) AS total_flights FROM flights;

SELECT AVG(mileage) AS average_mileage FROM flights;

SELECT AVG(seats) AS average_seats FROM aircrafts;

SELECT status, AVG(mileage) AS average_mileage FROM customers GROUP BY status;

SELECT status, MAX(mileage) AS max_mileage FROM customers GROUP BY status;

SELECT COUNT(*) AS boeing_airplanes FROM aircrafts WHERE name LIKE '%Boeing%';

SELECT * FROM flights WHERE mileage BETWEEN 300 AND 2000;

SELECT c.status AS status, AVG(f.mileage) AS average_flight_mileage FROM bookings b
INNER JOIN customers c ON b.customer_id = c.id
INNER JOIN flights f ON b.flight_id = f.id GROUP BY c.status;

SELECT a.name AS aircraft, COUNT(*) AS total_bookings FROM bookings b
INNER JOIN customers c ON b.customer_id = c.id
INNER JOIN flights f ON b.flight_id = f.id
INNER JOIN aircrafts a ON f.aircraft_id = a.id
WHERE c.status = 'Gold' GROUP BY a.name ORDER BY total_bookings DESC LIMIT 1;

SELECT DISTINCT c.name AS customer, c.status AS status, f.number AS flight_number,
a.name AS aircraft, a.seats AS seats, f.mileage AS flight_mileage,
c.mileage AS total_customer_mileage FROM bookings b
INNER JOIN customers c ON b.customer_id = c.id
INNER JOIN flights f ON b.flight_id = f.id
INNER JOIN aircrafts a ON f.aircraft_id = a.id;

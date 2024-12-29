--- CREATE SCRIPT

CREATE TABLE Blocks
(
    block_number     SERIAL PRIMARY KEY,
    type_of_block    VARCHAR(10) NOT NULL CHECK (type_of_block IN ('Old', 'New')),
    number_of_floors INT         NOT NULL
);
CREATE TABLE Rooms
(
    room_id      SERIAL PRIMARY KEY,
    block_number INT REFERENCES Blocks (block_number),
    room_number  INT NOT NULL
);
CREATE TABLE Students
(
    student_id        SERIAL PRIMARY KEY,
    name              VARCHAR(100) NOT NULL,
    surname           VARCHAR(100) NOT NULL,
    dob               DATE         NOT NULL,
    sex               VARCHAR(10)  NOT NULL CHECK (sex IN ('Male', 'Female', 'Other')),
    phone_number      VARCHAR(15),
    country_of_origin VARCHAR(50)
);
CREATE TABLE Employees
(
    employee_id   SERIAL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    role          VARCHAR(20)  NOT NULL CHECK (role IN ('Custodian', 'Cleaning Staff')),
    hire_date     DATE         NOT NULL,
    contact_phone VARCHAR(15)  NOT NULL,
    address       VARCHAR(200),
    email         VARCHAR(100)
);
CREATE TABLE Working
(
    block_number INT NOT NULL REFERENCES Blocks (block_number),
    employee_id  INT NOT NULL REFERENCES Employees (employee_id),
    PRIMARY KEY (block_number, employee_id)
);
CREATE TABLE Agreements
(
    agreement_id     SERIAL PRIMARY KEY,
    room_id          INT REFERENCES Rooms (room_id),
    student_id       INT REFERENCES Students (student_id),
    start_date       DATE           NOT NULL,
    end_date         DATE           NOT NULL,
    date_time_signed TIMESTAMP      NOT NULL,
    monthly_payment  NUMERIC(10, 2) NOT NULL,
    custodian_id     INT REFERENCES Employees (employee_id)
);
CREATE TABLE Repairs
(
    repair_id        SERIAL PRIMARY KEY,
    room_id          INT REFERENCES Rooms (room_id),
    repair_type      VARCHAR(50) NOT NULL,
    repair_date      DATE        NOT NULL,
    cost             NUMERIC(10, 2),
    custodian_id     INT REFERENCES Employees (employee_id),
    repairer_name    VARCHAR(100),
    repairer_contact VARCHAR(15)
);
CREATE TABLE Cleaning_Services
(
    service_id         SERIAL PRIMARY KEY,
    service_type       VARCHAR(50) NOT NULL,
    room_id            INT REFERENCES Rooms (room_id),
    request_date       DATE        NOT NULL,
    done               BOOLEAN     NOT NULL DEFAULT FALSE,
    cleaning_person_id INT REFERENCES Employees (employee_id),
    custodian_id       INT REFERENCES Employees (employee_id)
);


---- INSERT SCRIPT


INSERT INTO Blocks (type_of_block, number_of_floors)
VALUES ('Old', 3),
       ('Old', 5),
       ('New', 6),
       ('New', 6),
       ('New', 7),
       ('Old', 4),
       ('New', 8);
INSERT INTO Rooms (block_number, room_number)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 2),
       (4, 1),
       (5, 1),
       (5, 2),
       (5, 3),
       (5, 4),
       (3, 10),
       (4, 11);
INSERT INTO Students (name, surname, dob, sex, phone_number, country_of_origin)
VALUES ('Albert', 'Einstein', '2003-03-14', 'Male', '123-456-7890', 'Germany'),
       ('Marie', 'Curie', '2004-11-07', 'Female', '234-567-8901', 'Poland'),
       ('William', 'Shakespeare', '2002-04-23', 'Male', '345-678-9012', 'UK'),
       ('Amelia', 'Earhart', '2003-07-24', 'Female', '456-789-0123', 'USA'),
       ('Alex', 'Jordan', '2004-02-12', 'Other', '567-890-1234', 'Canada'),
       ('James', 'Smith', '2000-05-15', 'Male', '789-012-3456', 'USA'),
       ('Emma', 'Johnson', '1999-07-30', 'Female', '890-123-4567', 'UK');
INSERT INTO Employees (name, role, hire_date, contact_phone, address, email)
VALUES ('Isaac Newton', 'Custodian', '2019-08-01', '555-1234', '123 Apple St', 'isaac.newton@example.com'),
       ('Leonardo da Vinci', 'Custodian', '2018-04-15', '555-5678', NULL, 'leonardo.davinci@example.com'),
       ('Nikola Tesla', 'Custodian', '2020-07-10', '555-8765', '456 Electra Ave', NULL),
       ('Ada Lovelace', 'Custodian', '2021-12-10', '555-4321', NULL, NULL),
       ('Michael Faraday', 'Cleaning Staff', '2022-03-15', '555-6543', '789 Field Ln', 'michael.faraday@example.com'),
       ('Marie Curie', 'Cleaning Staff', '2021-11-20', '555-3456', NULL, 'marie.curie@example.com');
INSERT INTO Agreements (room_id, student_id, start_date, end_date, date_time_signed, monthly_payment, custodian_id)
VALUES (1, 1, '2024-01-01', '2024-06-30', '2023-12-04 00:00:00', 500.00, 1),
       (1, 2, '2024-01-01', '2024-06-30', '2023-12-04 00:00:00', 500.00, 1),
       (2, 3, '2024-02-21', '2025-12-31', '2023-12-04 00:00:00', 500.00, 1),
       (3, 4, '2024-01-01', '2024-03-31', '2023-12-04 00:00:00', 500.00, 2),
       (4, 5, '2024-01-01', '2025-06-30', '2023-12-04 00:00:00', 500.00, 2),
       (6, 3, '2024-02-21', '2025-01-31', '2023-12-04 00:00:00', 400.00, 3),
       (7, 4, '2024-03-01', '2025-03-01', '2023-12-04 00:00:00', 450.00, 4);
INSERT INTO Repairs (room_id, repair_type, repair_date, cost, custodian_id, repairer_name, repairer_contact)
VALUES (3, 'Plumbing', '2024-10-10', 120.00, 1, 'Nikola Tesla', '567-890-1234'),
       (4, 'Electrical', '2024-10-15', NULL, 2, 'James Watt', '678-901-2345'),
       (6, 'Carpentry', '2024-10-20', 75.50, 3, 'Thomas Edison', '789-012-3456'),
       (8, 'HVAC', '2024-11-01', 200.00, 4, 'Alexander Graham Bell', '890-123-4567'),
       (5, 'Painting', '2024-11-05', 150.00, 2, 'Michael Faraday', '901-234-5678'),
       (7, 'Roof Repair', '2024-11-10', 300.00, 1, 'Henry Ford', '012-345-6789'),
       (3, 'Window Repair', '2024-12-02', 120.00, 2, 'James Watt', '678-901-2345'),
       (9, 'Plumbing', '2024-12-02', 200.00, 3, 'Nikola Tesla', '123-456-7890'),
       (10, 'Painting', '2024-12-03', 150.00, 4, 'Michael Faraday', '234-567-8901');
INSERT INTO Working (block_number, employee_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (1, 2),
       (3, 1);
INSERT INTO Cleaning_Services (service_type, room_id, request_date, done, cleaning_person_id, custodian_id)
VALUES ('Garbage Removal', 1, '2024-11-25', TRUE, 5, 1),
       ('Floor Cleaning', 2, '2024-11-26', TRUE, 6, 2),
       ('Window Washing', 4, '2024-11-27', FALSE, 5, NULL),
       ('Dusting', 4, '2024-11-28', TRUE, 6, 1),
       ('Dusting', 3, '2024-11-30', TRUE, 5, NULL),
       ('Garbage Removal', 3, '2024-12-01', FALSE, 6, 2),
       ('Floor Cleaning', 3, '2024-11-29', TRUE, 5, NULL),
       ('Dusting', 8, '2024-12-01', TRUE, 5, 1),
       ('Floor Cleaning', 9, '2024-12-02', TRUE, 6, 2);


--- CLIENT USER CONFIGURATIONS

CREATE USER client_service WITH PASSWORD 'jouhl99866';
GRANT CONNECT ON DATABASE postgres TO client_service;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO client_service;

GRANT USAGE, SELECT, UPDATE ON SEQUENCE students_student_id_seq TO client_service;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE agreements_agreement_id_seq TO client_service;
GRANT USAGE, SELECT, UPDATE ON SEQUENCE repairs_repair_id_seq TO client_service;
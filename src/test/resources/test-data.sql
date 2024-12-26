CREATE TABLE employees (
                           employee_id INT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           role VARCHAR(20) NOT NULL CHECK (role IN ('Custodian', 'Cleaning Staff')),
                           hire_date DATE NOT NULL,
                           contact_phone VARCHAR(15) NOT NULL
);

CREATE TABLE cleaning_services (
                                   service_id INT PRIMARY KEY,
                                   service_type VARCHAR(50) NOT NULL,
                                   room_id INT NOT NULL,
                                   request_date DATE NOT NULL,
                                   done BOOLEAN NOT NULL DEFAULT FALSE,
                                   cleaning_person_id INT NOT NULL,
                                   FOREIGN KEY (cleaning_person_id) REFERENCES employees(employee_id)
);

INSERT INTO employees (employee_id, name, role, hire_date, contact_phone) VALUES
(1, 'Marie Curie', 'Cleaning Staff', '2021-01-01', '123-456-7890'),
(2, 'Michael Faraday', 'Cleaning Staff', '2020-01-01', '987-654-3210');

INSERT INTO cleaning_services (service_id, service_type, room_id, request_date, done, cleaning_person_id) VALUES
 (1, 'Dusting', 1, '2024-12-01', TRUE, 1),
 (2, 'Garbage Removal', 2, '2024-12-01', TRUE, 1),
 (3, 'Floor Cleaning', 3, '2024-12-01', TRUE, 1);




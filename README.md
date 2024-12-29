# Dormitory Catalog Service Client
This project is a** RESTful API** Dormitory Catalog Service designed to manage different aspects of a student dormitory system. It interacts with a PostgreSQL database , ensuring efficient way to manage agreements, cleaning services, repairs, and student information.

## Running the Project
Requirements:
  - Java 21 installed.
  - Local PostgreSQL DataBase configured.*
  - Gradle build tool .

Setup:
- Clone the repository.
- Update the PostgreSQL connection in application.properties.
- Execute the SQL scripts in ```resources``` to set up the database schema.

Build and Run:
Project build:

```bash
./gradlew build
```

Start the application:

```bash
././gradlew bootRun
```
**Nota Bene** The project runs with a locally configured PostgreSQL database. The database schema is initialized using the SQL script provided in ```resources/db_create_script.sql```. Before running the project, ensure the database is up and configured as per the script.

## Features and Functionality

The service supports CRUD operations for different entities in the dormitory system, implementing the main HTTP request types (**GET**, **POST**, **DELETE**, **PUT**) and simulating practical database interactions relevant to such a system. 

 ### Main features list:
 - **Salary Report for Cleaning Staff**: Generates a detailed salary reports for cleaning staff based on services completed within a given timeframe.
 - **List Available Rooms**: Retrieve a list of rooms available for new agreements, checking current occupancy.
 - **Add Agreement**: Creates a new rent agreement for a student with information about the custodian, room, and payment details.
 - **Delete Agreement**: Removes an existing agreement by its ID.
 - **Mark Cleaning as Done**: Updates the complection status of a cleaning service to true.
 - **Add New Repair**: Registers a repair request with detailed information, including cost, repairer details, and custodian who created a request.
 - **Add New Student**: Registers a new student in the dormitory catalog with personal and additional information.



## Request Templates
The ```resources``` folder contains a file named ```requests-list```, which provides HTTP request templates for each service feature, including request type (GET, POST, DELETE, PUT) and an endpoint's URLs.

## Project Structure
The project is organized for the of clarity and easy scalability, each entity contains a package of connected to it feauters, including all layers (repo's, services and controllers)

```
com.kotlinspring
├── cleaning_services
│   ├── salary_report
│   │   ├── SalaryReportController.kt
│   │   ├── SalaryReportDTO.kt
│   │   ├── SalaryReportRepository.kt
│   │   ├── SalaryReportService.kt
│   ├── mark_cleaning_done
│       ├── MarkCleaningDoneController.kt
│       ├── MarkCleaningDoneService.kt
resources
└── requests-list.txt
```

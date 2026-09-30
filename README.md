# Dhaka Metro Rail Management System

A Java-based desktop application with FXML-driven user interfaces, developed as an Object-Oriented Programming (OOP) project for managing Dhaka Metro Rail operations, users, stations, trains, schedules, passenger services, and administrative workflows.

---

## Project Overview

The **Dhaka Metro Rail Management System** is a desktop software solution designed to model and manage different operational aspects of a metro rail system through a role-based interface.

The system provides separate workflows for passengers, administrators, station managers, train operators, and other operational roles. It demonstrates object-oriented software design, GUI development with FXML, file-based persistence using Java object serialization, role-based access, data validation, reporting, and interactive data visualization.

The project was developed as an academic software engineering and OOP implementation project.

---

## Screenshots

### Login & System Entry

![Login Screen](docs/screenshots/login.png)

### Main Dashboard

![Dashboard](docs/screenshots/dashboard.png)

### User Management

![Add User](docs/screenshots/add-user.png)

### Train Management

![Train Management](docs/screenshots/train-management.png)

### Reports & Data Visualization

![Reports and Charts](docs/screenshots/reports-charts.png)

> More application screens are available in the `docs/screenshots/` directory.

---

## Key Features

### User & Role Management

- User registration and login
- Role-based access and dashboards
- Employee and passenger account management
- Automated user identity generation and validation
- Administrative user creation and management

### Passenger Services

- Passenger account management
- Ticket purchasing
- Fare calculation
- Transaction history
- Ticket refund and cancellation workflows
- Real-time train information
- Lost and found reporting
- Feedback submission
- Emergency-related passenger support

### Train & Station Management

- Train information management
- Station management
- Train scheduling
- Route-related information
- Operational resource management
- Station-level reporting

### Reports & Visualization

- Operational reports
- Statistical information
- Interactive charts
- Administrative monitoring and reporting workflows

---

## System Roles

The application was designed around multiple system roles, including:

| Role | Main Responsibilities |
|------|------------------------|
| Passenger | Ticket purchase, transaction history, train information, feedback, lost & found, emergency services |
| System Administrator | User management, system configuration, train and operational management |
| Station Manager | Station operations, reporting, resource requests and related management |
| Train Operator | Train-related operational workflows |
| Accountant | Financial and transaction-related workflows |
| Maintenance Staff | Maintenance-related operational workflows |
| Public Service Provider | Public service and passenger-support workflows |
| Head of HR | Employee and staff-related management |

---

## Object-Oriented Design

The project demonstrates core Object-Oriented Programming principles through a structured domain model.

### Major OOP Concepts

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Interfaces
- Abstract classes
- Object composition
- Role-based domain modeling

The system contains reusable domain classes for users, employees, passengers, trains, stations, routes, schedules, transactions, reports, and related entities.

Examples include:

- `User`
- `Employee`
- `Passenger`
- `SystemAdministrator`
- `StationManager`
- `TrainOperator`
- `Train`
- `Station`
- `Route`
- `TrainSchedule`
- `TransactionHistory`

The user hierarchy and role-specific classes were designed to represent different actors within the metro rail system.

---

## Application Architecture

The application follows a structured desktop application design consisting broadly of:

```text
Presentation Layer
        │
        ├── FXML Views
        ├── Controllers
        └── CSS / UI Assets
        │
        ▼
Application Logic
        │
        ├── Authentication
        ├── Validation
        ├── Role Management
        ├── Business Workflows
        └── Reporting
        │
        ▼
Domain Model
        │
        ├── Users
        ├── Employees
        ├── Passengers
        ├── Trains
        ├── Stations
        ├── Routes
        └── Transactions
        │
        ▼
Persistence Layer
        │
        └── Java Object Serialization
            (.bin files)

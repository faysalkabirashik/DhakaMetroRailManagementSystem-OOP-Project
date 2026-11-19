# Dhaka Metro Rail Management System

> A role-based desktop application built with **Java and FXML** to model and manage passenger services, users, trains, stations, schedules, reporting, and administrative workflows for a Dhaka Metro Rail environment.

[![Java](https://img.shields.io/badge/Java-8-orange?style=flat-square&logo=openjdk&logoColor=white)](https://www.java.com/)
![Java FXML UI](https://img.shields.io/badge/UI-Java%20FXML-blue?style=flat-square)
[![OOP](https://img.shields.io/badge/Design-OOP-6f42c1?style=flat-square)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Desktop Application](https://img.shields.io/badge/Application-Desktop-2ea44f?style=flat-square)](#)

---

## Table of Contents

- [Overview](#overview)
- [What This Project Demonstrates](#what-this-project-demonstrates)
- [A Few UI Snapshots](#a-few-ui-snapshots)
- [Core Features](#core-features)
- [System Roles](#system-roles)
- [Application Workflow](#application-workflow)
- [Technical Architecture](#technical-architecture)
- [Object-Oriented Design](#object-oriented-design)
- [Persistence and Data Handling](#persistence-and-data-handling)
- [Project Structure](#project-structure)
- [Technology Stack](#technology-stack)
- [How to Run](#how-to-run)
- [Application Screens](#application-screens)
- [Technical Highlights](#technical-highlights)
- [Project Scope](#project-scope)
- [Limitations](#limitations)
- [Future Development](#future-development)
- [Academic Context](#academic-context)
- [Author](#author)

---

## Overview

The **Dhaka Metro Rail Management System** is an academic desktop software project developed to represent the major operational workflows of a metro rail management environment.

The application provides a **role-based interface** through which different users can perform tasks associated with passenger services, user administration, station operations, train management, scheduling, reporting, and related operational activities.

The project focuses on applying **Object-Oriented Programming (OOP)** concepts to a real-world inspired software system rather than implementing a single-purpose application.

### Main areas covered

- User registration and authentication
- Role-based access and dashboards
- Passenger ticketing and transaction workflows
- Train and station management
- Train scheduling
- Operational information and reporting
- Feedback and lost-and-found services
- Emergency-related passenger support
- Data validation
- File-based persistence
- Charts and statistical visualization
- Desktop GUI development using FXML

---

## What This Project Demonstrates

This project brings together several software engineering concepts in one desktop application:

**Object-Oriented Programming**
- Abstract classes
- Inheritance
- Encapsulation
- Interfaces
- Polymorphism
- Composition
- Role-specific domain models

**Application Development**
- Authentication and authorization
- Form-based data entry
- Input validation
- Event-driven UI workflows
- Controller-based application logic
- Multiple application views

**Software Modeling**
- Domain-oriented class design
- Role-based system modeling
- UML-oriented analysis and design
- Separation of views, controllers, and domain classes

**Persistence**
- Java object serialization
- Multiple serialized data files
- Read/write workflows for application objects

---

## A Few UI Snapshots

The following images show selected screens from the desktop application. They are already stored in the repository under `Dhaka MetroRail Final/src/images/`, so you do **not** need to create a separate `docs/screenshots/` folder or upload duplicate copies.

### Login Interface

![Login Interface](Dhaka%20MetroRail%20Final/src/images/Login_page_ss.png)

### New User and Account Setup

![New User and Account Setup](Dhaka%20MetroRail%20Final/src/images/dashboard_new_user_ss.png)

### Train Management — Add New Train

![Add New Train](Dhaka%20MetroRail%20Final/src/images/add_train_dashboard.png)

### Dashboard — User Distribution Chart

![Dashboard User Distribution Chart](Dhaka%20MetroRail%20Final/src/images/dashboard-pie_chart.png)

> These are a few representative UI snapshots; the repository contains additional application screens and visual assets in the same `src/images/` directory.
---

## Core Features

### 1. Authentication and User Management

The system includes authentication and role-based access control.

Main capabilities include:

- User login
- User registration
- Role-based dashboard routing
- Employee and passenger account management
- User identity generation
- Input validation
- Administrative user creation
- Role-specific access to application workflows

---

### 2. Passenger Services

Passenger-oriented workflows include:

- Passenger account management
- Ticket purchasing
- Fare calculation
- Transaction history
- Refund and cancellation workflows
- Real-time train information
- Lost-and-found reporting
- Feedback submission
- Emergency-related support

---

### 3. Train Management

The application provides functionality for managing train-related information, including:

- Train records
- Train configuration
- Train-related operational information
- Train scheduling
- Route-related information
- Train operator workflows

---

### 4. Station Management

Station-oriented functionality includes:

- Station information management
- Station-level operational workflows
- Resource requests
- Station reporting
- Related administrative operations

---

### 5. Reporting and Visualization

The system includes reporting and visualization functionality for operational and administrative use.

Examples include:

- Statistical information
- Reports
- Charts
- Data summaries
- Administrative monitoring workflows

---

### 6. Feedback, Lost & Found, and Emergency Support

Passenger-service workflows also cover:

- Feedback submission
- Lost-and-found records
- Emergency-related information
- Passenger support workflows

---

## System Roles

The application models several roles within the metro rail environment.

| Role | Main Responsibilities |
|---|---|
| **Passenger** | Ticket purchase, transaction history, train information, feedback, lost & found, emergency-related services |
| **System Administrator** | User management, system configuration, train and operational management |
| **Station Manager** | Station operations, reports, resource requests, station-related management |
| **Train Operator** | Train-related operational workflows |
| **Accountant** | Financial and transaction-related workflows |
| **Maintenance Staff** | Maintenance-related workflows |
| **Public Service Provider** | Public service and passenger-support workflows |
| **Head of HR** | Employee and staff-related management |

The role structure is represented through separate domain classes and role-specific application views.

---

## Application Workflow

A simplified workflow of the application is:

```text
                 ┌─────────────────────┐
                 │      Start App      │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │   Login / Register  │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │ Authentication &    │
                 │ Role Verification   │
                 └──────────┬──────────┘
                            │
          ┌─────────────────┼─────────────────┐
          │                 │                 │
          ▼                 ▼                 ▼
     Passenger        Administrator     Staff / Operations
       Workflow          Workflow            Workflow
          │                 │                 │
          ▼                 ▼                 ▼
     Services &       User / Train /     Station / Train /
     Transactions       System Mgmt.       Reporting
          │                 │                 │
          └─────────────────┼─────────────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │ Read / Update Data  │
                 └─────────────────────┘
```

---

## Technical Architecture

The application is organized around four broad layers:

```text
┌─────────────────────────────────────────────────┐
│                 Presentation Layer              │
│                                                 │
│  FXML Views  │  Controllers  │  CSS / Assets   │
└──────────────────────────┬──────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────┐
│                Application Logic                │
│                                                 │
│ Authentication │ Validation │ Role Routing     │
│ Business Workflows │ Reports │ UI Operations   │
└──────────────────────────┬──────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────┐
│                   Domain Model                  │
│                                                 │
│ Users │ Employees │ Passengers │ Trains         │
│ Stations │ Routes │ Schedules │ Transactions    │
└──────────────────────────┬──────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────┐
│                  Persistence                    │
│                                                 │
│            Java Object Serialization            │
│                    (.bin files)                 │
└─────────────────────────────────────────────────┘
```

### Presentation Layer

The user interface is built from **FXML view files** with Java controllers handling application events and workflow logic.

The project also contains:

- CSS styling
- UI images and icons
- Dashboard views
- Login and registration views
- Role-specific views

### Application Logic

The controller and supporting classes handle:

- Login verification
- Validation
- Role routing
- User operations
- Passenger transactions
- Train and station workflows
- Reports
- Application-specific business logic

### Domain Model

The domain model contains reusable classes representing the main objects of the system.

Examples include:

```text
User
Employee
Passenger
SystemAdministrator
StationManager
TrainOperator
Train
Station
Route
TrainSchedule
TransactionHistory
```

### Persistence Layer

The current academic implementation uses **Java object serialization** for persistence.

Objects are written to and read from serialized `.bin` files.

---

## Object-Oriented Design

One of the main goals of the project was to demonstrate practical OOP concepts through a real-world inspired domain.

### Abstract Classes

The application contains abstract domain types such as:

```text
User
Employee
```

These provide common behavior and structure for more specialized classes.

### Inheritance

Examples of the role hierarchy include:

```text
User
 ├── Employee
 │    ├── SystemAdministrator
 │    ├── StationManager
 │    ├── TrainOperator
 │    ├── HeadOfHR
 │    ├── Accountant
 │    ├── MaintenanceStaff
 │    └── PublicServiceProvider
 │
 └── Passenger
```

This structure allows common user-related functionality to be reused while preserving role-specific behavior.

### Interfaces

The project also uses interfaces for reusable contracts and role-related behavior.

Examples include:

```text
Classifiable
Countable
```

### Encapsulation

Application data and operations are organized inside domain classes rather than being kept as unrelated global values.

### Polymorphism

Role-specific objects can be handled through common parent types while retaining their specialized behavior.

### Composition

Domain objects such as trains, stations, schedules, routes, users, and transactions are combined to represent larger system workflows.

---

## Persistence and Data Handling

The existing implementation uses Java object serialization rather than a relational database.

Serialized application data is stored in `.bin` files, including files associated with areas such as:

```text
UserObjects.bin
LoginInfoObjects.bin
EmployeeObjects.bin
Passenger.bin
SystemAdministrator.bin
StationManager.bin
TrainOperator.bin
Accountant.bin
MaintenanceStaff.bin
PublicServiceProvider.bin
HeadOfHR.bin
TransactionHistory.bin
Emergency.bin
LostAndFound.bin
RealTimeUpdate.bin
```

### Important Note

These files are part of the current academic implementation because application workflows depend on reading and writing serialized objects.

For that reason, they should **not be removed from the existing Java project simply for repository cleanup** without first checking the application dependencies.

For a future redesigned C++ implementation, a proper database-backed persistence layer can be introduced separately.

---

## Project Structure

The main project is contained inside the `Dhaka MetroRail Final` directory.

A simplified structure is:

```text
DhakaMetroRailManagementSystem-OOP-Project/
│
├── Dhaka MetroRail Final/
│   │
│   ├── src/
│   │   ├── bintest/
│   │   ├── charttest/
│   │   ├── images/
│   │   ├── login/
│   │   │   └── faysal/
│   │   ├── mainpkg/
│   │   ├── model/
│   │   │   ├── faysal/
│   │   │   └── nayem/
│   │   └── view/
│   │       ├── faysal/
│   │       └── nayem/
│   │
│   ├── nbproject/
│   ├── build.xml
│   ├── manifest.mf
│   ├── *.bin
│   ├── build/
│   └── dist/
│
├── .gitignore
├── .gitattributes
└── README.md
```

### Source Organization

| Directory | Purpose |
|---|---|
| `src/login/` | Login and authentication UI/controller |
| `src/mainpkg/` | Main application entry point |
| `src/model/` | Domain models and supporting classes |
| `src/view/` | Role-specific UI views and controllers |
| `src/images/` | Application images, icons, and visual assets |
| `src/charttest/` | Chart-related application functionality |
| `nbproject/` | NetBeans project configuration |

---

## Technology Stack

### Programming Language

- **Java**
- Java source/target configuration: **1.8**

### User Interface

- **FXML**
- CSS
- Java controllers
- Event-driven desktop UI

### Development Environment

- NetBeans project structure
- Java development tools
- Git / GitHub

### Application Concepts

- Object-Oriented Programming
- Serialization
- Role-based access
- Data validation
- Desktop GUI development
- File-based persistence
- Reporting
- Data visualization

---

## How to Run

### Prerequisites

Install:

- **Java 8**
- **NetBeans** with support for the project's FXML-based desktop configuration
- Git, if cloning the repository

### Option 1 — Clone the Repository

```bash
git clone https://github.com/faysalkabirashik/DhakaMetroRailManagementSystem-OOP-Project.git
```

Then open the repository in NetBeans.

### Option 2 — Open the Existing NetBeans Project

1. Open **NetBeans**.
2. Select **File → Open Project**.
3. Select the project directory:

```text
Dhaka MetroRail Final/
```

4. Wait for NetBeans to load the project configuration.
5. Ensure the project is using the required Java 8 environment.
6. Build the project.
7. Run the application from the configured main class.

The project entry point is:

```text
mainpkg.MainApplicationClass
```

### Important

The application currently uses serialized `.bin` files for persistent data.

Keep the required `.bin` files with the project when testing the existing implementation, because application workflows read and write those files.

---

## Application Screens

The application contains multiple role-based and functional screens.

### Login and Registration

The login section provides:

- User authentication
- Username/password validation
- Role identification
- Application routing after successful login
- Registration-related workflows

### Administrative Screens

Administrative workflows include screens for:

- User management
- Add user
- Edit user
- Delete user
- System administration
- Train management
- Operational information

### Station Manager Screens

Station-oriented screens support:

- Station management
- Reports
- Resource-related workflows
- Station operations

### Passenger Screens

Passenger-facing screens include workflows for:

- Passenger dashboard
- Ticket purchase
- Transaction history
- Real-time train information
- Feedback
- Lost and found
- Emergency support
- Refund/cancellation-related operations

### Reporting and Charts

The system also includes reporting and chart-oriented views to present operational and statistical information.

---

## Technical Highlights

### Role-Based Application Design

Different roles are routed to different dashboards and workflows instead of exposing every operation to every user.

### Reusable Domain Model

The project uses a structured model for users, employees, passengers, trains, stations, routes, schedules, and transactions.

### FXML-Based UI

UI layouts are separated from controller logic using FXML view files.

This makes it easier to organize:

- Forms
- Dashboards
- Navigation
- Tables
- Administrative screens
- Passenger screens

### Validation

The project includes validation-related classes for checking application input such as:

- Usernames
- Passwords
- Email information
- Dates
- User-related data

### Serialization-Based Persistence

The system demonstrates object persistence through Java serialization and `.bin` files.

### Reporting and Visualization

The application contains report-generation workflows and chart-based data presentation for administrative and operational use.

---

## Project Scope

This repository represents the **original academic Java/FXML implementation** of the Dhaka Metro Rail Management System.

The project was designed primarily to demonstrate:

- OOP principles
- GUI development
- Application logic
- Role-based workflows
- Domain modeling
- Data persistence
- Software project development

It should therefore be understood as an **academic software system / simulation**, not as an official metro rail management platform.

---

## Limitations

The current version has several characteristics that reflect its academic project scope.

### File-Based Persistence

The application uses serialized `.bin` files rather than a production-grade relational database.

### Legacy Desktop Configuration

The existing project uses an older Java/NetBeans configuration and Java 8-based project settings.

### Academic Scope

The system models representative metro rail workflows and is not intended to serve as a production deployment for a real railway operator.

### Repository Organization

The original academic repository contains development and generated project artifacts from the original development environment.

The existing Java implementation should not be aggressively cleaned without verifying dependencies, especially where serialized files are required by the application.

---

## Future Development

A future redesigned version can evolve the system into a more maintainable and production-oriented application.

Possible improvements include:

### Modern C++ Implementation

- Rebuild the core application in C++
- Introduce a cleaner project architecture
- Improve modularity and maintainability
- Implement stronger separation between UI, business logic, and persistence

### Database Integration

Replace file-based serialization with a proper database such as:

- SQLite for a self-contained desktop version
- MySQL for a client/server architecture

### Improved Persistence Layer

Introduce repositories/services for:

- Users
- Passengers
- Trains
- Stations
- Schedules
- Transactions
- Reports

### Security Improvements

- Password hashing
- Better authentication handling
- Stronger authorization
- Secure credential storage

### Modern UI

- Improved visual design
- Responsive layouts
- Better navigation
- Consistent component design
- Improved accessibility

### Testing

Introduce:

- Unit testing
- Integration testing
- Validation testing
- Regression testing
- Automated build/testing workflows

---

## Academic Context

**Project:** Dhaka Metro Rail Management System

**Type:** Academic Desktop Software Project

**Focus:** Object-Oriented Programming, GUI Development, Role-Based Application Design, Domain Modeling, Persistence, Reporting, and Software Engineering

**Institution:** Independent University, Bangladesh

The project was developed as part of academic coursework and collaborative software development activities.

---

## Author

### Md. Foysal Kabir Ashik

Software Engineer · CSE Graduate · Systems & Software Development

<p>
  <a href="https://github.com/faysalkabirashik">
    <img src="https://img.shields.io/badge/GitHub-faysalkabirashik-181717?style=flat-square&logo=github&logoColor=white" alt="GitHub">
  </a>
  <a href="https://www.linkedin.com/in/foysalkabirashik/">
    <img src="https://img.shields.io/badge/LinkedIn-Connect-0A66C2?style=flat-square&logo=linkedin&logoColor=white" alt="LinkedIn">
  </a>
  <a href="mailto:faysalkabirashik@gmail.com">
    <img src="https://img.shields.io/badge/Email-Contact-EA4335?style=flat-square&logo=gmail&logoColor=white" alt="Email">
  </a>
</p>

### Repository

[Dhaka Metro Rail Management System — GitHub](https://github.com/faysalkabirashik/DhakaMetroRailManagementSystem-OOP-Project)

---

## Notes for Reviewers

This repository is the **original Java/FXML academic implementation**.

The main strengths of the project are its role-based system design, object-oriented domain structure, multiple functional workflows, FXML-based desktop interface, serialized object persistence, and integration of application logic with a substantial set of screens and domain classes.

A future redesigned implementation can preserve the same domain concept while replacing the legacy persistence and project structure with a cleaner architecture and database-backed storage.

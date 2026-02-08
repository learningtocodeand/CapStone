# 💸 Money Transfer System

A secure and scalable **Money Transfer System** built using **Spring Boot**, designed to handle reliable fund transfers with full transactional integrity and auditability.  
The backend exposes RESTful APIs and is designed for seamless integration with an **Angular frontend** and a cloud-native **Snowflake** database.

This project follows **industry best practices** in backend architecture, security, and data consistency, making it suitable for real-world financial application scenarios.



## 📌 Features

- Secure money transfer between accounts
- Atomic debit and credit operations
- Transaction audit logging
- Authentication and authorization using Spring Security
- Layered architecture (Controller → Service → Repository)
- RESTful APIs designed for frontend integration
- Input validation and meaningful error handling
- Transaction rollback on failure
- Unit and integration tests for core business logic



## 🏗️ Architecture Overview
Client (Angular)
↓
REST API (Spring Boot)
↓
Service Layer (Business Logic)
↓
Repository Layer (JPA)
↓
Database (Snowflake)



## 🧰 Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Spring Security
- Maven

### Frontend (Planned)
- Angular

### Database
- Snowflake (primary analytical datastore)
- MySQL (local and development environment)

### Testing
- JUnit 5
- Spring Boot Test
- MockMvc


## 🔐 Security

- Authentication and authorization implemented using **Spring Security**
- Protected endpoints require authenticated access
- Passwords stored securely using hashing (BCrypt)
- Designed to support JWT-based authentication for frontend integration



## 🔄 Transaction Management

- Uses Spring’s `@Transactional` support
- Ensures atomicity of debit and credit operations
- Automatic rollback on any failure during money transfer
- Maintains consistent and reliable system state



## 🚀 Getting Started

### Prerequisites
- Java 17
- Maven
- Snowflake account (for analytics and scaling)

### Run the Application

```bash
mvn clean install
mvn spring-boot:run



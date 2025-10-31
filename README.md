# 🚗 Car Rental Management System  
![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?logo=postgresql)
![JWT](https://img.shields.io/badge/Security-JWT-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A **Spring Boot backend** for managing users, vehicles, and bookings in a car rental system.  
Includes **JWT Authentication**, **Role-Based Access**, and full **CRUD APIs**.

---

## 🧠 Overview
This RESTful backend provides:
- 👤 User registration and JWT-based login  
- 🔐 Role-based access control (Admin / User)  
- 🚘 Vehicle management (CRUD + filters)  
- 📅 Booking management with auto-calculated amounts  

---

## ⚙️ Tech Stack
Java 17+
Spring Boot 3.x
Spring Security (JWT Authentication)
Spring Data JPA (Hibernate)
PostgreSQL Database
Maven Build Tool

## 🚀 Features
  -👤 User Management
- Register new users (password encrypted with BCrypt)
- Login and receive JWT token
- Roles: ADMIN / USER

🚘 Vehicle Management
- Add, update, delete, and list all vehicles
- Search by name, brand, or type
- Filter by availability or price range
- Pagination and sorting supported

📅 Booking Management
- Create bookings linked to users and vehicles
- Automatically calculate total amount (days * pricePerDay)
- Retrieve bookings by user ID or all (Admin only)

## 🔐 Role-Based Access Control
/register/add             -> Public
/register/verify          -> Public
/vehicle/show             -> Public
/vehicle/add, /delete/**  -> Admin Only
/booking/add              -> User Only
/booking/show             -> Admin Only

## 🪪 JWT Authentication Flow
1️⃣ Register User
POST /register/add
Body:
{
  "username": "john",
  "password": "1234",
  "role": "USER"
}

2️⃣ Login
POST /register/verify
Body:
{
  "username": "john",
  "password": "1234"
}
Response: JWT Token

3️⃣ Use JWT
Header:
Authorization: Bearer <your-token>

## 🗄️ Database Schema
UserEntity
- id (Integer)
- username (String)
- password (String)
- role (Enum: ADMIN/USER)

VehicleEntity
- id (Integer)
- name (String)
- vehicleType (String)
- brand (String)
- pricePerDay (Double)
- available (Boolean)

BookingEntity
- id (Integer)
- vehicle (FK)
- user (FK)
- startDate (LocalDate)
- endDate (LocalDate)
- amount (Double)

## 🧪 Example API Calls
 Add Vehicle (Admin)
POST /vehicle/add
Authorization: Bearer <JWT>
Content-Type: application/json

{
  "name": "Honda City",
  "vehicleType": "Sedan",
  "brand": "Honda",
  "pricePerDay": 1800.0,
  "available": true
}

## Create Booking (User)
POST /booking/add
Authorization: Bearer <JWT>
Content-Type: application/json

{
  "vehicle": { "id": 1 },
  "user": { "id": 2 },
  "startDate": "2025-11-01",
  "endDate": "2025-11-05"
}

## 🧠 Future Improvements
- 🧾 Add Swagger / OpenAPI Documentation
- 📧 Email Verification / OTP Login
- 💳 Payment Gateway Integration
- 💻 React / Angular Frontend
- 📊 Admin Dashboard
🗑️ Soft Delete for Vehicles


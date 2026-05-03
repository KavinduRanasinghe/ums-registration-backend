# 🎓 WUSL Academic Registration & Timetable Management System

## 📘 Overview

The **WUSL Academic System** is a full-stack, enterprise-grade platform designed for the **Faculty of Applied Sciences (FAS), Wayamba University of Sri Lanka (WUSL)**.

It digitizes and automates:

* Student registration
* Combination (path) selection
* Module enrollment
* Approval workflows
* Timetable generation (future phase)

---

## 🎯 Objectives

* Eliminate manual academic registration processes
* Ensure compliance with faculty prospectus rules
* Prevent scheduling conflicts
* Provide a scalable, SaaS-ready architecture

---

## 🏗️ System Architecture

The system follows a **Client–Server Architecture** with **Clean Architecture principles**.

```plaintext
Frontend (React - planned)
        ↓
REST API (Spring Boot)
        ↓
Application Layer (Use Cases)
        ↓
Domain Layer (Entities & Rules)
        ↓
PostgreSQL Database
```

---

## ⚙️ Tech Stack

### Backend

* Java 17 (LTS)
* Spring Boot 3.5.x
* Spring Data JPA (Hibernate 6)
* Maven

### Database

* PostgreSQL 15

### Frontend (Planned)

* React (Vite)
* Tailwind CSS

### Future Integration

* Timefold Solver (Timetable optimization)

---

## 📂 Project Structure

```plaintext
lk.ac.wusl.fas.academic
│
├── domain            # Core business entities & repositories
├── application       # Use cases, services, DTOs
├── infrastructure    # Configurations (DB, CORS, ENV)
├── interfaces        # REST controllers & exception handling
├── shared            # Utilities & custom exceptions
```

---

## 🚀 Features Implemented

### ✅ Student Management

* Student registration API
* Stores student academic details

### ✅ Course Registration

* Create academic registration per student
* Supports level-based registration

### ✅ Module Management

* Fetch modules (dropdown API)
* Semester-based filtering

### ✅ Module Selection

* Students select modules
* Linked to registration

### ✅ PostgreSQL Integration

* Fully connected database
* Auto table generation via JPA

---

## 🔐 Environment Configuration

Create a `.env` file in the project root:

```env
DB_URL=jdbc:postgresql://localhost:5432/wusl_academic_db
DB_USERNAME=postgres
DB_PASSWORD=your_password
SERVER_PORT=8080
```

---

## ⚙️ Application Properties

```properties
spring.config.import=optional:file:.env[.properties]

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🗄️ Database Setup

```sql
CREATE DATABASE wusl_academic_db;
```

---

## ▶️ Running the Application

### Option 1 — IntelliJ

Run:

```
AcademicSystemApplication.java
```

### Option 2 — Terminal

```bash
mvnw spring-boot:run
```

---

## 🌐 API Endpoints

### 🎓 Register Student

```http
POST /api/students
```

---

### 🧾 Create Registration

```http
POST /api/registrations?studentId={id}&level=1
```

---

### 📚 Get Modules (Dropdown)

```http
GET /api/modules?level=1&semester=1
```

---

### 📦 Select Modules

```http
POST /api/module-selections?registrationId={id}
```

Body:

```json
["CMIS1113", "MATH1112"]
```

---

## 🧪 Example Request

```json
{
  "regNo": "2021001",
  "name": "Kavindu Ranasinghe",
  "initials": "K.R.",
  "gender": "Male",
  "district": "Kurunegala",
  "zScore": 1.85,
  "level": 1
}
```

---

## 📈 Future Enhancements

* 🔄 Combination assignment (Z-score based)
* 📊 Approval workflow (Mentor → HOD → Counsellor)
* 🧠 Timetable generation using Timefold
* 📱 Student-friendly frontend (React)
* 🔐 Authentication & role-based access
* ☁️ Multi-tenant SaaS architecture

---

## 🧠 Design Principles

* Clean Architecture
* Separation of concerns
* Scalable modular design
* Secure configuration (.env)
* RESTful API design

---

## ⚠️ Notes

* Only stable versions are used (no SNAPSHOT dependencies)
* PostgreSQL 15 is fully supported
* Java 17 ensures long-term compatibility

---

## 👨‍💻 Author

**Kavindu Ranasinghe**
Faculty of Applied Sciences
Wayamba University of Sri Lanka

---

## 📄 License

This project is developed for academic and research purposes.

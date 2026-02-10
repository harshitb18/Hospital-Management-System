# **Hospital Management System (HMS) — README**

## **Project Overview**

This is a **Spring Boot-based Hospital Management System (HMS)** designed as a learning project to cover core Spring Boot and backend concepts. It is **not a full-fledged hospital system**, but it implements realistic workflows around patients, doctors, appointments, and availability management.

The system supports two main roles:

* **Patient (Self-service user)**
* **Receptionist / Admin (Operational control)**

The backend is built using:

* **Spring Boot**
* **Spring Data JPA**
* **MySQL (running on Docker)**
* **Maven**

---

## **High-Level Architecture**

```
Client (Postman / Frontend)
        ↓
Spring Boot Controller (REST APIs)
        ↓
Service Layer (Business Logic + @Transactional)
        ↓
Repository Layer (Spring Data JPA)
        ↓
MySQL Database (Docker)
```

---

## **Core Features**

### **Patient Features**

A patient can:

* Register themselves
* Update their details
* Delete their profile
* View available doctors on a given day
* View available doctors for a specific time slot
* Book an appointment
* View their appointments
* Cancel their appointment

### **Admin / Receptionist Features**

Admin can:

* Create, Read, Update, Delete (CRUD) Patients
* CRUD Doctors
* Set doctor availability and unavailability
* CRUD Appointments
* Approve or reject appointment requests

---

## **Appointment Status Flow**

Each appointment can have one of the following statuses:

```
PENDING → CONFIRMED / CANCELLED → COMPLETED
```

* A new appointment starts as **PENDING**
* Admin/Doctor can **CONFIRM** or **CANCEL**
* After consultation, it is marked **COMPLETED**

---

## **Planned Database Tables**

### **1) Patient**

```
patient_id (PK)
name
age
gender
phone
email
address
created_at
updated_at
```

### **2) Doctor**

```
doctor_id (PK)
name
specialization
phone
email
status (ACTIVE / INACTIVE)
```

### **3) Slot (Recommended for Availability Management)**

```
slot_id (PK)
doctor_id (FK)
date
start_time
end_time
status (AVAILABLE / BOOKED / UNAVAILABLE)
```

### **4) Appointment**

```
appointment_id (PK)
patient_id (FK)
doctor_id (FK)
slot_id (FK)
status (PENDING / CONFIRMED / CANCELLED / COMPLETED)
created_at
```

---

## **Expected REST APIs**

### **Patient APIs**

```
POST   /patients
PUT    /patients/{patientId}
DELETE /patients/{patientId}

GET    /doctors/available?date=YYYY-MM-DD
GET    /doctors/available?date=YYYY-MM-DD&time=HH:MM

POST   /appointments
GET    /patients/{patientId}/appointments
DELETE /appointments/{appointmentId}
```

### **Admin / Receptionist APIs**

```
GET    /admin/patients
GET    /admin/patients/{id}
POST   /admin/patients
PUT    /admin/patients/{id}
DELETE /admin/patients/{id}

GET    /admin/doctors
GET    /admin/doctors/{id}
POST   /admin/doctors
PUT    /admin/doctors/{id}
DELETE /admin/doctors/{id}

POST   /admin/doctors/{doctorId}/slots
PUT    /admin/slots/{slotId}

GET    /admin/appointments
POST   /admin/appointments
PUT    /admin/appointments/{appointmentId}
DELETE /admin/appointments/{appointmentId}

PUT    /admin/appointments/{appointmentId}/status
PUT    /admin/appointments/{appointmentId}/complete

GET    /doctors/{doctorId}
PUT    /doctors/{doctorId}

GET    /doctors/{doctorId}/slots
POST   /doctors/{doctorId}/slots
PUT    /doctors/slots/{slotId}
DELETE /doctors/slots/{slotId}

GET    /doctors/{doctorId}/appointments
GET    /doctors/{doctorId}/appointments?date=
GET    /doctors/{doctorId}/appointments?status=

PUT    /doctors/appointments/{appointmentId}/status
PUT    /doctors/appointments/{appointmentId}/complete

GET    /doctors/{doctorId}/dashboard   (optional)

```

---

## **Business Rules**

* A patient cannot book two appointments with the same doctor at the same time.
* Once a slot is booked, it should not appear as available.
* If an appointment is cancelled, the slot becomes available again.
* Only Admin/Doctor can confirm or reject appointments.
* Patients can only cancel their own appointments.

---

## **Tech Stack**

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL (Docker)
* Maven
* Postman (for API testing)

---

## **Future Enhancements**

* Add Spring Security with JWT authentication
* Role-based access (Patient vs Admin)
* Frontend using React
* Email notifications for appointment confirmation
* Doctor dashboard
* Appointment analytics

---

## **How to Run the Project (Basic)**

1. Start MySQL using Docker:

```
docker run --name hms-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=hms_db -p 3306:3306 -d mysql:8
```

2. Run the Spring Boot application:

```
mvn spring-boot:run
```

---

## **Contributing**

Feel free to fork and improve the project. Pull requests are welcome.

---

## **Author**

Harshith B
****

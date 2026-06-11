# 🚀 Spring Boot Job Portal Backend

A robust Job Portal Backend Application built using Spring Boot, Spring Security, Spring Data JPA, Hibernate, and MySQL. This project provides secure authentication and complete CRUD operations for managing job postings through REST APIs.

---

## 📌 Features

### 🔐 Authentication & Security

* Spring Security Integration
* Database-backed User Authentication
* BCrypt Password Encryption
* HTTP Basic Authentication
* Secure REST APIs

### 💼 Job Management

* Create Job Posts
* View All Job Posts
* Search Jobs by Keyword
* Update Existing Job Posts
* Delete Job Posts

### 🗄️ Database Integration

* MySQL Database
* Spring Data JPA
* Hibernate ORM
* Repository Pattern Implementation

### ⚡ Additional Features

* Aspect-Oriented Programming (AOP)
* Performance Monitoring Aspect
* Validation Aspect
* Logging Aspect
* RESTful API Design

---

## 🛠️ Tech Stack

| Technology      | Purpose                        |
| --------------- | ------------------------------ |
| Java            | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | Database Access Layer          |
| Hibernate       | ORM Framework                  |
| MySQL           | Relational Database            |
| Maven           | Dependency Management          |
| Postman         | API Testing                    |

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── model
├── config
├── aop
└── resources
```

---

## 🔗 REST API Endpoints

### Job APIs

| Method | Endpoint                   | Description   |
| ------ | -------------------------- | ------------- |
| GET    | /jobPosts                  | Get All Jobs  |
| GET    | /jobPost/{id}              | Get Job By ID |
| POST   | /jobPost                   | Add New Job   |
| PUT    | /jobPost                   | Update Job    |
| DELETE | /jobPost/{id}              | Delete Job    |
| GET    | /jobPost/keyword/{keyword} | Search Jobs   |

---

## 🔒 Authentication

This project uses Spring Security with database authentication.

Example User:

```text
Username: Aayush
Password: Singh@123
```

Passwords are stored using BCrypt encryption for enhanced security.

---

## 🚀 Getting Started

### Clone Repository

```bash
git clone https://github.com/AashishKumarOfficial/spring-boot-job-portal.git
```

### Navigate to Project

```bash
cd spring-boot-job-portal
```

### Run Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

## 🧪 API Testing

All APIs have been tested using Postman.

Example:

```http
GET http://localhost:8080/jobPosts
```

---

## 📈 Skills Demonstrated

* Spring Boot Development
* Spring Security Authentication
* REST API Development
* MySQL Database Design
* Hibernate & JPA
* AOP (Aspect-Oriented Programming)
* Git & GitHub
* Postman API Testing

---

## 👨‍💻 Author

**Aashish Kumar**

Computer Science Engineering Student

GitHub: https://github.com/AashishKumarOfficial

 Course Management System
markdown
Copy
Edit
# 📚 Course Management System (Full Stack)

A full-stack web application that enables Admins, Instructors, and Students to interact with a secure course management platform. This system uses Spring Boot + JWT for backend security and React.js for frontend interaction.

---

## 📌 Project Goals

- 👤 Role-based Access Control (Admin, Instructor, Student)
- 🔐 Secure Authentication using JWT
- 📦 REST API using Spring Boot
- 🧑‍🏫 Instructor can create and manage courses
- 🧑‍🎓 Students can enroll and view courses
- 🛡️ Admin can view all users

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 3.5
- Spring Security 6
- JWT (JJWT 0.11.5)
- MySQL 8
- Maven

### Frontend
- React.js
- Axios
- React Router

---

## 🗂️ Folder Structure

com.coursemanagement.cms
├── config # Spring Security config
├── controller # Auth, Course, Enrollment, Admin
├── dto # Request/Response DTOs
├── entity # User, Role, Course, Enrollment
├── repository # JpaRepositories
├── security # JWT Filter, Token Util
├── service # Auth, Course, Enrollment, Admin

yaml
Copy
Edit

---

## 🚀 Day-to-Day Functionalities (Features by Role)

### 👤 Student
- Register & Login
- View all available courses
- Enroll in a course
- View enrolled courses

### 👨‍🏫 Instructor
- Register & Login
- Create new courses
- View all courses they created

### 🛠 Admin
- View all users
- Manage system users and roles (future feature)

---

## 🔐 Authentication & Authorization

- JWT-based login
- `Authorization: Bearer <token>` in all API requests
- Role-based access via `@PreAuthorize`
- Stateless session management

---

## 📬 API Endpoints

### 🔹 AuthController `/api/auth`
| Method | Endpoint         | Role      | Description          |
|--------|------------------|-----------|----------------------|
| POST   | /register         | Public    | Register user        |
| POST   | /login            | Public    | Authenticate & JWT   |

### 🔹 CourseController `/api/courses`
| Method | Endpoint         | Role         | Description                  |
|--------|------------------|--------------|------------------------------|
| GET    | /                | All          | Get all courses              |
| POST   | /                | INSTRUCTOR   | Create a new course          |

### 🔹 EnrollmentController `/api/enrollments`
| Method | Endpoint           | Role      | Description                  |
|--------|--------------------|-----------|------------------------------|
| POST   | /{courseId}        | STUDENT   | Enroll in a course           |

### 🔹 AdminController `/api/admin`
| Method | Endpoint           | Role      | Description                  |
|--------|--------------------|-----------|------------------------------|
| GET    | /users             | ADMIN     | View all registered users    |

---

## ⚙️ Setup Instructions

### ✅ Prerequisites
- Java 21
- Maven
- MySQL running on `localhost:3306`
- React (Node.js + npm)

---

### 🧩 Backend Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/course-management-system.git
   cd cms
Create MySQL database:

sql
Copy
Edit
CREATE DATABASE course_db;
Edit src/main/resources/application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/course_db
spring.datasource.username=root
spring.datasource.password=your_password
Add initial roles (auto-seeded):

ROLE_ADMIN

ROLE_INSTRUCTOR

ROLE_STUDENT

Build and run:

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
🧩 Frontend Setup
Navigate to the frontend directory (if you have it):

bash
Copy
Edit
cd frontend
Install dependencies:

bash
Copy
Edit
npm install
Run frontend:

bash
Copy
Edit
npm start
Frontend runs on: http://localhost:3000

📦 Maven Dependencies
xml
Copy
Edit
<!-- Spring Boot Starters -->
<dependency> org.springframework.boot:spring-boot-starter-web </dependency>
<dependency> org.springframework.boot:spring-boot-starter-security </dependency>
<dependency> org.springframework.boot:spring-boot-starter-data-jpa </dependency>

<!-- JWT -->
<dependency> io.jsonwebtoken:jjwt-api:0.11.5 </dependency>
<dependency> io.jsonwebtoken:jjwt-impl:0.11.5 </dependency>
<dependency> io.jsonwebtoken:jjwt-jackson:0.11.5 </dependency>

<!-- MySQL -->
<dependency> com.mysql:mysql-connector-j:8.3.0 </dependency>

<!-- Lombok (optional if used) -->
<dependency> org.projectlombok:lombok </dependency>
🛡 Security Features
JWT Authentication

Stateless sessions

Role-based method security via @PreAuthorize

Passwords hashed with BCrypt

🌱 Future Improvements
Forgot password/reset email

Instructor course enrollment tracking

Admin dashboard with user management

Pagination & search in courses

Email notifications (e.g., enrollment confirmation)

🙌 Author
Satya Chowdary
Course Management System – Built with Java, Spring Boot, and React

⭐️ License
MIT License (or your preferred license)

yaml
Copy
Edit

---

Let me know if you'd like:
- A second version of this README for deployment (e.g., Heroku/AWS)
- React frontend code to match this backend  
- CI/CD setup instructions  
- Swagger/OpenAPI documentation

Ready for the frontend setup or want to create a default admin user now?








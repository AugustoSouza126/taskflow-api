# TaskFlow API

TaskFlow API is a RESTful backend application developed with Java and Spring Boot for task management and productivity workflows.

The project provides JWT authentication, user-specific task ownership, secure access control, task management operations, and PostgreSQL persistence.

## Live API

Production URL:

https://taskflow-api-zytv.onrender.com](https://taskflow-frontend-eight-psi.vercel.app/

Swagger Documentation:

https://taskflow-api-zytv.onrender.com/swagger-ui/index.html

## Features

### Authentication & Security

* User registration
* User login
* JWT token generation
* JWT validation
* Protected endpoints
* BCrypt password encryption
* Spring Security integration
* User-specific task ownership

### Task Management

* Create tasks
* List all tasks
* Search task by ID
* Update tasks
* Delete tasks
* Filter tasks by status
* Task ownership validation

### Database

* PostgreSQL integration
* JPA/Hibernate persistence
* Automatic schema update

### Documentation

* Swagger / OpenAPI integration

## Technologies

* Java 21
* Spring Boot 4
* Spring Security
* Spring Data JPA
* PostgreSQL
* JWT (JJWT)
* Docker
* Maven
* Lombok
* Swagger / OpenAPI

## Architecture

```text
Client
   ↓
Spring Security
   ↓
JWT Filter
   ↓
Controllers
   ↓
Services
   ↓
Repositories
   ↓
PostgreSQL
```

## Project Structure

```text
src/main/java
├── config
├── controller
├── dto
├── model
├── repository
├── service
└── TaskflowApplication
```

## Authentication Flow

```text
User Login
     ↓
JWT Token Generated
     ↓
Authorization: Bearer <token>
     ↓
Protected Endpoints
```

## Task Status

```text
TODO
IN_PROGRESS
DONE
```

## API Endpoints

### Authentication

| Method | Endpoint       | Description            |
| ------ | -------------- | ---------------------- |
| POST   | /auth/register | Register a new user    |
| POST   | /auth/login    | Authenticate user      |
| GET    | /auth/me       | Get authenticated user |
| GET    | /auth/test     | Validate JWT token     |

### Tasks

| Method | Endpoint               | Description            |
| ------ | ---------------------- | ---------------------- |
| GET    | /tasks                 | List user tasks        |
| GET    | /tasks/{id}            | Get task by id         |
| POST   | /tasks                 | Create task            |
| PUT    | /tasks/{id}            | Update task            |
| DELETE | /tasks/{id}            | Delete task            |
| GET    | /tasks/status/{status} | Filter tasks by status |

## Running Locally

### Prerequisites

* Java 21
* Maven
* PostgreSQL

### Configure Database

Update application.properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Run Application

```bash
./mvnw spring-boot:run
```

or

```bash
./mvnw clean package
java -jar target/Taskflow-0.0.1-SNAPSHOT.jar
```

Application:

```text
http://localhost:8081
```

Swagger:

```text
http://localhost:8081/swagger-ui/index.html
```

## Docker

Build image:

```bash
docker build -t taskflow-api .
```

Run container:

```bash
docker run -p 8080:8080 taskflow-api
```

## Deployment

### Backend

* Render

### Database

* Neon PostgreSQL

### Frontend

* Vercel

## Future Improvements

* Refresh Token Authentication
* Unit Tests
* Integration Tests
* CI/CD Pipeline
* Role-Based Authorization (Admin/User)

## Author

Augusto Souza

Computer Science Student – URI Santiago

GitHub:
https://github.com/AugustoSouza126

LinkedIn:
https://www.linkedin.com/in/augusto-souza-795324313/

# TaskFlow API

TaskFlow is a RESTful API built with Java and Spring Boot for task management. The project includes authentication and authorization using JWT, input validation, exception handling, pagination, and user-specific task management.

## Features

### Authentication

- User registration
- User login
- JWT token generation
- Protected endpoints
- Password encryption with BCrypt

### Task Management

- Create tasks
- List tasks
- Search task by ID
- Update tasks
- Delete tasks
- Filter tasks by status
- Pagination support

### Security

- Spring Security
- JWT Authentication
- User-specific tasks
- Protected routes

## Technologies

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JJWT)
- Lombok
- Maven
- Swagger/OpenAPI

## Project Structure

```text
src/main/java
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── config
```

## Authentication Flow

```text
User Login
     ↓
JWT Token
     ↓
Authorization: Bearer <token>
     ↓
Protected Endpoints
```

## API Endpoints

### Authentication

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | /auth/register | Register a new user |
| POST | /auth/login | Authenticate user |
| GET | /auth/test | Test JWT token |

### Tasks

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | /tasks | Get user tasks |
| GET | /tasks/{id} | Get task by id |
| POST | /tasks | Create task |
| PUT | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |
| GET | /tasks/status/{status} | Filter tasks by status |
| GET | /tasks/paged | Paginated tasks |

## Task Status

- TODO
- IN_PROGRESS
- DONE

## Security Features

- JWT Authentication
- BCrypt Password Hashing
- Route Protection
- User Ownership Validation

## Future Improvements

- Docker support
- React Frontend
- Cloud Deployment
- Unit Tests

## Author

Augusto Souza

Computer Science Student

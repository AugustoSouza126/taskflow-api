# TaskFlow API

TaskFlow API is a RESTful backend application developed with Java and Spring Boot for task and productivity management. The project follows a layered architecture and includes authentication, validation, exception handling, pagination, and task status management.

## Features

* User registration
* User authentication with JWT
* Password encryption using BCrypt
* Create tasks
* List tasks
* Get task by ID
* Update tasks
* Delete tasks
* Task status management
* Pagination support
* Input validation
* Global exception handling
* API documentation with Swagger/OpenAPI

## Technologies

* Java 21
* Spring Boot 4
* Spring Security
* JWT Authentication
* Spring Data JPA
* PostgreSQL
* Lombok
* Maven
* Swagger / OpenAPI

## Architecture

```text
controller/
service/
repository/
model/
dto/
exception/
config/
```

## Task Status

* TODO
* IN_PROGRESS
* DONE

## Authentication

### Register

```http
POST /auth/register
```

### Login

```http
POST /auth/login
```

Returns a JWT token used to access protected resources.

## Main Endpoints

| Method | Endpoint               | Description            |
| ------ | ---------------------- | ---------------------- |
| GET    | /tasks                 | Get all tasks          |
| GET    | /tasks/{id}            | Get task by ID         |
| POST   | /tasks                 | Create a task          |
| PUT    | /tasks/{id}            | Update a task          |
| DELETE | /tasks/{id}            | Delete a task          |
| GET    | /tasks/status/{status} | Filter tasks by status |
| GET    | /tasks/paged           | Paginated task listing |

## Security Features

* JWT Authentication
* Password hashing with BCrypt
* Email uniqueness validation
* Protected endpoints with Spring Security

## Future Improvements

* Role-based authorization (ADMIN / USER)
* User-specific task ownership
* Docker support
* Deployment with Render or Railway
* Unit and integration tests
* Frontend with React

## Author

Augusto Souza

Computer Science Student | Backend Developer (Java & Spring Boot)

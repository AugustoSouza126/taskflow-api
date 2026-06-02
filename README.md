TaskFlow API

TaskFlow is a RESTful API developed with Java and Spring Boot for task management and productivity workflows. The project includes authentication and authorization using JWT, user-specific task ownership, Docker support, input validation, exception handling, and pagination.

Features
Authentication & Security
User registration
User login
JWT token generation
Protected endpoints
BCrypt password encryption
User-specific task access
Spring Security integration
Task Management
Create tasks
List tasks
Search task by ID
Update tasks
Delete tasks
Filter tasks by status
Pagination support
Technologies
Java 21
Spring Boot 4
Spring Security
Spring Data JPA
PostgreSQL
JWT (JJWT)
Docker & Docker Compose
Lombok
Maven
Swagger / OpenAPI
Project Structure
src/main/java
├── config
├── controller
├── dto
├── exception
├── model
├── repository
└── service
Authentication Flow
User Login
     ↓
JWT Token
     ↓
Authorization: Bearer <token>
     ↓
Protected Endpoints
Task Status
TODO
IN_PROGRESS
DONE
API Endpoints
Authentication
Method	Endpoint	Description
POST	/auth/register	Register a new user
POST	/auth/login	Authenticate user
GET	/auth/test	Validate JWT token
Tasks
Method	Endpoint	Description
GET	/tasks	Get all tasks from authenticated user
GET	/tasks/{id}	Get task by id
POST	/tasks	Create a task
PUT	/tasks/{id}	Update a task
DELETE	/tasks/{id}	Delete a task
GET	/tasks/status/{status}	Filter by status
GET	/tasks/paged	Paginated task listing
Running Locally
Prerequisites
Java 21
Maven
PostgreSQL
Configure Database

Update the application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow
spring.datasource.username=postgres
spring.datasource.password=your_password
Run Application
./mvnw spring-boot:run

Or:

./mvnw clean package
java -jar target/Taskflow-0.0.1-SNAPSHOT.jar

Application:

http://localhost:8080

Swagger:

http://localhost:8080/swagger-ui/index.html
Running with Docker
Build Containers
docker compose build
Start Containers
docker compose up
Stop Containers
docker compose down

Application:

http://localhost:8080

Swagger:

http://localhost:8080/swagger-ui/index.html
Future Improvements
React Frontend
Cloud Deployment (AWS/Railway/Render)
Unit and Integration Tests
CI/CD Pipeline
Refresh Token Authentication
Author

Augusto Souza

Computer Science Student

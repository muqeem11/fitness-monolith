# Fitness Monolith (Backend)

A simple Spring Boot backend for a fitness demo application. Provides user authentication, activity management, and exercise recommendations.

**Tech stack**
- Java 17
- Spring Boot 4
- Spring Data JPA (PostgreSQL runtime)
- Spring Security + JWT
- OpenAPI (springdoc)
- Maven


## Project Summary

- **Fitness Monolith** is a compact Spring Boot backend that demonstrates user authentication (JWT), activity tracking, and recommendation generation. The codebase emphasizes clean layering (controller → service → repository), secure endpoints, and OpenAPI documentation.

## Why this project stands out

- **Technical breadth:** Security, persistence (JPA), REST API design, and OpenAPI.
- **Production-minded:** Dockerfile provided, environment-driven configuration, and sensible defaults.
- **Readable structure:** Small, focused packages for `controller`, `service`, `repository`, `security`, and `dto`.

## Tech stack

- Java 17
- Spring Boot 4 (WebMVC, Security, Data JPA)
- PostgreSQL (runtime driver included)
- JWT (io.jsonwebtoken)
- OpenAPI (springdoc)
- Maven

## Quickstart (local)

1. Set required environment variables (PowerShell example):

```powershell
Set-Item -Path Env:DB_URL -Value "jdbc:postgresql://localhost:5432/fitness_demo"
Set-Item -Path Env:DB_USER -Value "postgres"
Set-Item -Path Env:DB_PWD -Value "password"
```

2. Build and run:

```powershell
mvn clean package -DskipTests
java -jar target/fitness-monolith-0.0.1-SNAPSHOT.jar
```

3. Open the API docs:

- http://localhost:8080/swagger-ui/index.html

Alternatively, run with the Spring Boot plugin:

```powershell
mvn spring-boot:run
```

## Docker

Build and run the image:

```powershell
docker build -t fitness-monolith:latest .
docker run -e DB_URL="jdbc:postgresql://host.docker.internal:5432/fitness_demo" -e DB_USER=postgres -e DB_PWD=password -p 8080:8080 fitness-monolith:latest
```

## Configuration

Key environment variables (mapped in `src/main/resources/application.properties`):

- `DB_URL` — JDBC URL (e.g. `jdbc:postgresql://localhost:5432/fitness_demo`)
- `DB_USER` — DB username
- `DB_PWD` — DB password

## Selected Endpoints (examples to show in interview)

- `POST /api/auth/register` — register user (showcases validation and DTOs)
- `POST /api/auth/login` — obtains JWT
- `POST /api/activities` — create activity (authenticated)
- `GET  /api/activities` — list activities
- `POST /api/recommendation/generate` — recommendation generation endpoint

Example curl to login:

```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"dev","password":"pwd"}'
```

## What to highlight to a recruiter / interviewer

- Project structure and where to find responsibilities:
  - Controllers: src/main/java/com/project/fitness/controller
  - Services: src/main/java/com/project/fitness/service
  - Security: src/main/java/com/project/fitness/security
- How JWT is issued/validated (`JwtUtils`, `JwtAuthenticationFilter`).
- Database mapping and entities (`model` package) and how JPA is used for persistence.
- API documentation via Springdoc (`OpenApiConfig`).

## Tests

Run unit tests:

```powershell
mvn test
```

## Next improvements (good talking points)

- Add integration tests (Postgres testcontainer), CI pipeline, and code coverage reporting.
- Add database migration via Flyway or Liquibase.
- Externalize secrets using a vault for production readiness.

## Contributing / Contact

Fork, open a PR, or contact the repo owner for questions. For interview demos, mention which areas you implemented and which you would extend (e.g., analytics, monitoring).

---

File: [README.md](README.md)

If you want, I can also:
- commit this change to git and push to a GitHub remote
- run `mvn test` locally and share results
- add a GitHub Actions CI workflow that runs tests on push


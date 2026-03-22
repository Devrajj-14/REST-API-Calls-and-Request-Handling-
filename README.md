# REST API Calls and Request Handling - Greeting App

## Task Summary

A Spring Boot REST API (Greeting App) built incrementally across 8 use cases, each developed on a separate git flow feature branch, merged to `develop`, and pushed to GitHub.

## Use Cases

| UC | Description | Endpoint | Branch |
|----|-------------|----------|--------|
| 1 | GreetingController with GET, POST, PUT, DELETE HTTP methods returning JSON | `GET/POST/PUT/DELETE /api/greeting` | `feature/uc1` |
| 2 | Service Layer - GreetingService returning "Hello World" | Same endpoints via service layer | `feature/uc2` |
| 3 | Greeting with User Names (firstName, lastName, or both) | `GET /api/greeting?firstName=X&lastName=Y` | `feature/uc3` |
| 4 | Save Greeting Message to Repository | `POST /api/greeting/save` | `feature/uc4` |
| 5 | Find Greeting Message by ID | `GET /api/greeting/{id}` | `feature/uc5` |
| 6 | List All Greeting Messages | `GET /api/greeting/all` | `feature/uc6` |
| 7 | Edit a Greeting Message | `PUT /api/greeting/update/{id}` | `feature/uc7` |
| 8 | Delete a Greeting Message | `DELETE /api/greeting/delete/{id}` | `feature/uc8` |

## Tech Stack

- **Java 17** with **Spring Boot 3.2.3**
- **Spring Data JPA** with **H2 In-Memory Database**
- **Maven** for build management
- **Git Flow** for branching strategy

## Branches

- `main` - Production branch (this README)
- `develop` - Development branch with all 8 UCs merged
- `feature/uc1` to `feature/uc8` - Individual feature branches

## How to Run

Switch to the `develop` branch to access the full source code:

```bash
git checkout develop
mvn spring-boot:run
```

The app runs on `http://localhost:8080`.

## Curl Test Examples

```bash
# GET greeting
curl http://localhost:8080/api/greeting

# Greeting with names
curl "http://localhost:8080/api/greeting?firstName=John&lastName=Doe"

# Save greeting
curl -X POST "http://localhost:8080/api/greeting/save?firstName=John&lastName=Doe"

# Find by ID
curl http://localhost:8080/api/greeting/1

# List all
curl http://localhost:8080/api/greeting/all

# Update greeting
curl -X PUT "http://localhost:8080/api/greeting/update/1?message=Updated+Greeting"

# Delete greeting
curl -X DELETE http://localhost:8080/api/greeting/delete/1
```

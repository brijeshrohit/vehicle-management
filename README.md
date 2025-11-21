# Vehicle Manager Backend

A Spring Boot backend for the **Vehicle Manager** application.  
Tracks **vehicles**, **fuel entries**, **maintenance records**, **mileage records**, and **expenses**.  
Built with Java, Spring Boot, H2, and Maven.  

---

## Table of Contents

- [Requirements](#requirements)  
- [Setup](#setup)  
- [Build & Run](#build--run)  
- [Database](#database)  
- [API Endpoints](#api-endpoints)  
- [Testing](#testing)  
- [CI/CD Pipeline](#cicd-pipeline)  

---

## Requirements

- Java 17 (or 21 if configured)  
- Maven 3.8+  
- Git  
- Optional: H2 database (for local development)  

---

## Setup

1. Clone the repository:

```bash
git clone <your-repo-url>
cd vehicle-manager
````

2. Build the project:

```bash
mvn clean install
```

---

## Build & Run

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The backend runs at:

```
http://localhost:8080
```

---

## Database (H2)

* H2 console: `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:mem:vehicle_db`
* Username: `sa`
* Password: *(leave empty)*

Flyway migrations automatically create tables and insert sample data.

---

## API Endpoints

### Vehicle

| Endpoint            | Method | Description       |
| ------------------- | ------ | ----------------- |
| `/api/vehicle/ping` | GET    | Ping test         |
| `/api/vehicle`      | GET    | Get all vehicles  |
| `/api/vehicle`      | POST   | Add new vehicle   |
| `/api/vehicle/{id}` | GET    | Get vehicle by ID |
| `/api/vehicle/{id}` | PUT    | Update vehicle    |
| `/api/vehicle/{id}` | DELETE | Delete vehicle    |

### Fuel

| Endpoint                | Method | Description                    |
| ----------------------- | ------ | ------------------------------ |
| `/api/fuel/{vehicleId}` | GET    | Get fuel entries for a vehicle |
| `/api/fuel`             | POST   | Add fuel entry                 |

### Maintenance

| Endpoint                       | Method | Description                           |
| ------------------------------ | ------ | ------------------------------------- |
| `/api/maintenance/{vehicleId}` | GET    | Get maintenance entries for a vehicle |
| `/api/maintenance`             | POST   | Add maintenance entry                 |

### Mileage

| Endpoint                   | Method | Description                       |
| -------------------------- | ------ | --------------------------------- |
| `/api/mileage/{vehicleId}` | GET    | Get mileage records for a vehicle |
| `/api/mileage`             | POST   | Add mileage record                |

### Expenses

| Endpoint                   | Method | Description                       |
| -------------------------- | ------ | --------------------------------- |
| `/api/expense/{vehicleId}` | GET    | Get expense records for a vehicle |
| `/api/expense`             | POST   | Add expense record                |

---

## Testing

Run unit tests:

```bash
mvn test
```

All tests must pass before merging code into main.

---

## CI/CD Pipeline

* Uses **GitHub Actions** for CI.
* Workflow: `.github/workflows/maven-ci.yml`
* Runs **Maven build + unit tests** on every push.
* If build/tests fail, workflow shows **failure** in Actions tab.

### Optional Local Pre-Push Hook

Prevent pushing failing code locally:

1. Create file `.git/hooks/pre-push`:

```bash
#!/bin/bash
echo "Running Maven build + tests before push..."
mvn clean install
if [ $? -ne 0 ]; then
    echo "Build failed! Push aborted."
    exit 1
fi
```

2. Make it executable:

```bash
chmod +x .git/hooks/pre-push
```

---

## Notes

* All entities use **UUIDs** as primary keys.
* Flyway handles database migrations automatically.
* Recommended to use **feature branches** and merge via pull requests.
* The project supports **H2 in-memory database** for local development and can be switched to production DB if required.

```

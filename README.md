# NexaBank — Spring Boot Banking Application

A full-stack banking web application built with **Java**, **Spring Boot**, **Spring Security**, and an **H2 in-memory database**. Features a clean green-themed frontend with customer registration, login, account management, fund transfers, and transaction history.

---

## Features

- **User Registration & Login** — customers register with their own username/password; admins use a separate login
- **Role-based access** — customers see only their own data; admins see all customers
- **Customer Management** — create, view, search, and delete customer profiles
- **Account Management** — open bank accounts (Savings, Checking, Fixed Deposit), look up account details
- **Fund Transfers** — transfer money between accounts
- **Transaction History** — view all transactions for any account
- **Swagger UI** — interactive API documentation
- **H2 Console** — in-browser database viewer

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 11 (JDK 24 compatible) |
| Framework | Spring Boot 2.1.4 |
| Security | Spring Security (BCrypt, HTTP Basic Auth) |
| Database | H2 In-Memory Database |
| ORM | Spring Data JPA / Hibernate |
| API Docs | Springfox Swagger 2.9.2 |
| Frontend | HTML5, CSS3, Vanilla JavaScript |
| Build | Maven 3.9.x |

---

## Getting Started

### Prerequisites

- JDK 24 (or 11+)
- Maven 3.9+ (or use the included `mvnw`)

### Run the App

```powershell
# Set environment (PowerShell)
$env:JAVA_HOME = "C:\Program Files\jdk-24.0.1"
$env:PATH = "C:\Users\pc\maven3\apache-maven-3.9.9\bin;" + $env:PATH

# Navigate to project
cd C:\Users\pc\Desktop\BankApp-master\BankApp-master

# Run
mvn spring-boot:run
```

The app starts on **http://localhost:8989/bank-api**

---

## Accessing the App

| Page | URL |
|------|-----|
| Login | http://localhost:8989/bank-api/index.html |
| Register | http://localhost:8989/bank-api/register.html |
| Dashboard | http://localhost:8989/bank-api/dashboard.html |
| Swagger UI | http://localhost:8989/bank-api/swagger-ui.html |
| H2 Console | http://localhost:8989/bank-api/h2-console |

### Default Admin Credentials

| Field | Value |
|-------|-------|
| Username | `bankapp` |
| Password | `changeit` |

---

## How It Works

### Customer Flow
1. Go to **Register** — fill in username, password, name, customer number, contact details
2. Go to **Login** — sign in with your username and password (Customer tab)
3. Dashboard shows **your profile only** — My Account, Accounts, Transfer, Transactions

### Admin Flow
1. Go to **Login** — click the **Admin** tab (auto-fills credentials)
2. Full access — view all customers, add/delete customers, manage all accounts

---

## API Endpoints

### Customers
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/customers/all` | Get all customers |
| POST | `/customers/add` | Add new customer |
| GET | `/customers/{customerNumber}` | Get customer by number |
| PUT | `/customers/{customerNumber}` | Update customer |
| DELETE | `/customers/{customerNumber}` | Delete customer |

### Accounts
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/accounts/{accountNumber}` | Get account details |
| POST | `/accounts/add/{customerNumber}` | Add account to customer |
| PUT | `/accounts/transfer/{customerNumber}` | Transfer funds |
| GET | `/accounts/transactions/{accountNumber}` | Get transactions |

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register new user |
| GET | `/auth/me` | Get current user info |

---

## GitHub

**Repository:** https://github.com/ben-can-code/BankApp  
**Author:** ben-can-code

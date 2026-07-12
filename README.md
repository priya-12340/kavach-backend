<div align="center">

# Kavach

### AI-Powered Women's Safety Platform — Backend

Real-time SOS alerts. Secure evidence storage. An AI companion when you need one most.

Built for **HackHazards '26**

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

[Features](#-features) • [Tech Stack](#️-tech-stack) • [Getting Started](#-getting-started) • [API Reference](#-api-reference) • [Team](#-team)

</div>

---

## 📖 About

**Kavach** (Hindi for "shield/armor") is a safety-first platform designed to give women a fast, reliable way to signal distress, preserve evidence, and get support — all in one place. This repo is the **backend**: a Spring Boot REST API that powers authentication, SOS alerting, evidence storage, and an integrated AI assistant.

🔗 **Frontend repo:** [kavach-frontend](https://github.com/priya-12340/kavach-frontend)

---

## ✨ Features

- **🆘 One-Tap SOS Alerts** — Trigger and log emergency alerts instantly, with alert history per user
- **📁 Evidence Vault** — Upload and securely store evidence (photos, audio, documents) tied to a user account
- **🔐 OTP-Based Auth** — Passwordless login/signup flow, backed by Spring Security
- **🤖 AI Chat Assistant** — Conversational support powered by the Claude API for real-time guidance
- **🌐 CORS-Ready REST APIs** — Configured out of the box to work with the React frontend
- **🗄️ Relational Data Layer** — Clean separation of concerns via JPA/Hibernate repositories

---

## 🏗️ Tech Stack

**Backend:** Java 17, Spring Boot, Spring Security, Spring Data JPA / Hibernate
**Data & Infra:** MySQL 8, Maven
**Integrations:** Claude API (Anthropic), React.js ([frontend repo](https://github.com/priya-12340/Kavach))

---

## 📂 Project Structure

kavach-backend/
├── src/main/java/com/kavach/kavach_backend/
│   ├── config/
│   │   └── SecurityConfig.java          # Spring Security configuration
│   ├── controller/
│   │   ├── ChatController.java          # AI assistant endpoints
│   │   ├── EvidenceController.java      # Evidence Vault APIs
│   │   ├── SOSAlertController.java      # SOS trigger & history
│   │   └── UserController.java          # Auth & user management
│   ├── model/
│   │   ├── Evidence.java
│   │   ├── SOSAlert.java
│   │   └── User.java
│   ├── repository/                      # Spring Data JPA repositories
│   ├── service/                         # Business logic layer
│   └── KavachBackendApplication.java    # Entry point
├── src/main/resources/
│   ├── application.properties           # Local config (gitignored, not committed)
│   ├── static/
│   └── templates/
├── pom.xml
└── README.md

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8.x running locally
- An [Anthropic API key](https://console.anthropic.com) for the chat feature

### 1. Clone the repo

```bash
git clone https://github.com/priya-12340/kavach-backend.git
cd kavach-backend
```

### 2. Set up the database

```sql
CREATE DATABASE kavach_db;
```

### 3. Configure environment

Create `src/main/resources/application.properties` (this file is gitignored — never commit it):

```properties
spring.application.name=kavach-backend

spring.datasource.url=jdbc:mysql://localhost:3306/kavach_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

The Anthropic API key is read from an environment variable, not from this file:

```bash
# Windows (PowerShell)
$env:ANTHROPIC_API_KEY="your_api_key_here"

# macOS/Linux
export ANTHROPIC_API_KEY="your_api_key_here"
```

### 4. Build & run

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The API will be live at `http://localhost:8080`.

---

## 📡 API Reference

| Method | Endpoint | Description |
|:------:|----------|-------------|
| `POST` | `/api/users/register` | Register a new user |
| `POST` | `/api/users/verify-otp` | Verify OTP and complete login |
| `POST` | `/api/sos/trigger` | Trigger an SOS alert |
| `GET` | `/api/sos/history` | Fetch SOS alert history |
| `POST` | `/api/evidence/upload` | Upload evidence to the vault |
| `GET` | `/api/evidence/{userId}` | Fetch a user's stored evidence |
| `POST` | `/api/chat` | Message the AI assistant |

> Paths above reflect the current controllers — update as new endpoints are added.

---

## 🔒 Security Notes

- Secrets (DB credentials, API keys) are **never committed** — `application.properties` is gitignored, and the Anthropic key is injected via environment variable.
- All write endpoints are protected through `SecurityConfig`.
- If you fork this repo, generate your own API key and database credentials — don't reuse anyone else's.

---

## 🔗 Related Repos

- **Frontend (React.js):** [kavach-frontend](https://github.com/priya-12340/kavach-frontend)

---

## 🧑‍🤝‍🧑 Team

Built by a 3-person team for HackHazards '26 — full-stack development, maps integration, and security.

---

## 📄 License

MIT — free to use and adapt for hackathon or learning purposes.

<div align="center">

**Made with ⚡ for a safer world**

</div>
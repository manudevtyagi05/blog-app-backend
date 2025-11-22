<div align="center">

# 📘 **Blog Application Backend – Spring Boot**

### 🚀 Modern, Modular & Secure REST API for a Complete Blogging Platform

**Version: v1.0 (Current)**

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)
![JWT](https://img.shields.io/badge/Security-JWT-orange)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Status](https://img.shields.io/badge/Build-Passing-brightgreen)

</div>

---

# 📌 **Table of Contents**

- [✨ Overview](#-overview)
<!-- Prettified README. The original README is preserved in `Readme.original.md`. -->
- [🧩 Features (v1.0)](#-features-v10)
- [📁 Project Structure](#-project-structure)

# 📘 Blog Application Backend — Spring Boot

- [🧭 API Endpoints](#-api-endpoints)
- [🛣 Roadmap (Upcoming Versions)](#-roadmap-upcoming-versions)
  [![Java 17](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
  [![Spring Boot 3](https://img.shields.io/badge/Spring%20Boot-3.0-green.svg)](https://spring.io/projects/spring-boot)
  [![JWT](https://img.shields.io/badge/Auth-JWT-orange.svg)](https://jwt.io)
  [![MySQL](https://img.shields.io/badge/DB-MySQL-blue.svg)](https://www.mysql.com)
- [📜 License](#-license)

---

# ✨ **Overview**

A **production-ready**, cleanly architected backend for a blogging platform built with:

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Configuration](#configuration)
- [API Summary](#api-summary)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
  Designed to scale into a full-featured blogging ecosystem with posts, categories, comments, likes, tagging, analytics, notifications, and more.

---

# 🧩 **Features (v1.0)**

A production-minded REST API for blogs: users, posts, comments, likes, categories and tags. It uses JWT for authentication and DTOs for clean responses.

## 🔐 **1. Authentication & Authorization**

## Features

- JWT authentication and Spring Security
- BCrypt password hashing
- User registration and profile management
- Post CRUD with draft/publish workflow
- Categories & tags (many-to-many)
- Comments and likes with ownership checks
- Global exception handling and DTO-based responses
- Role: `USER` _(Admin roles coming soon)_
- All protected API routes secured

---

- JWT login + token validation filter
- Stateless security
- `@AuthenticationPrincipal` user injection
- CustomUserDetailsService
- Role: `USER` _(Admin roles coming soon)_
- All protected API routes secured
  "success": false,
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Meaningful error message",
  "path": "/endpoint"
  }
  Handles:
  Bad Request

Resource Not Found

Forbidden

Unauthorized

Duplicate email/username

JWT errors

Validation errors

👤 3. User Module
User Fields
username

email

password (hashed)

bio

## Project Structure (high level)

- `src/` — application source
  - `auth/` — authentication controllers/services
  - `fhir-api/`, `openmrs/` — domain-specific modules
  - `prisma/` — database module
  - `patients/`, `queue/`, `redis/` — additional modules
  - `config/`, `common/`, `crypto/` — cross-cutting concerns

Refer to the `src/` folder for full module details.

## Requirements

- Java 17+
- Maven
- MySQL (or compatible DB)

## Quick Start

1. Clone the repository:

```bash
git clone <repo-url>
cd <repo-folder>
```

2. Configure the database in `src/main/resources/application.properties` (or via environment variables):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

3. Build and run:

```bash
mvn clean package
mvn spring-boot:run
```

Or run the produced jar:

```bash
java -jar target/*.jar
```

## Configuration

- Override settings via `application.properties` or environment variables.
- Configure JWT secrets and expiry in your security config (e.g., `security.jwt.secret`).

## API Summary

Base path: `/v1` (example)

- Auth

  - `POST /v1/auth/register` — register user
  - `POST /v1/auth/login` — login and receive JWT

- Users

  - `PUT /v1/user/{id}` — update profile
  - `DELETE /v1/user/{id}` — delete profile
  - `GET /v1/user/id/{id}` — get user by ID
  - `GET /v1/user/name/{name}` — get user by username

- Posts

  - `POST /v1/posts` — create post
  - `PUT /v1/posts/{id}` — update post
  - `PUT /v1/posts/{id}/publish` — publish post
  - `GET /v1/posts/{id}` — get post
  - `GET /v1/posts?page=&size=` — list posts (pagination)

- Categories & Tags

  - `POST /v1/categories` — create category
  - `GET /v1/categories` — list categories
  - `GET /v1/categories/{id}` — get category

- Comments

  - `POST /v1/comments/post/{postId}` — add comment
  - `PUT /v1/comments/{id}` — update comment
  - `DELETE /v1/comments/{id}` — delete comment

- Likes
  - `POST /v1/likes/post/{postId}` — toggle like
  - `GET /v1/likes/post/{postId}` — get likes for post

For request/response shapes, inspect DTOs under `src/**/dto` and controller tests.

## Roadmap

- v2.0: Admin roles, media uploads, improved RBAC
- v3.0+: Full-text search, analytics, trending features

## Contributing

Contributions welcome — open issues or PRs. Keep changes focused and include tests for new behavior.


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
- [🧩 Features (v1.0)](#-features-v10)
- [📁 Project Structure](#-project-structure)
- [⚙️ Setup & Installation](#️-setup--installation)
- [🧭 API Endpoints](#-api-endpoints)
- [🛣 Roadmap (Upcoming Versions)](#-roadmap-upcoming-versions)
- [🛠 Improvements Planned](#-improvements-planned)
- [📜 License](#-license)

---

# ✨ **Overview**
A **production-ready**, cleanly architected backend for a blogging platform built with:

- **Spring Boot 3**
- **Spring Security 6**
- **JWT Authentication**
- **MySQL**
- **DTO-driven clean API responses**
- **Modular layered architecture**

Designed to scale into a full-featured blogging ecosystem with posts, categories, comments, likes, tagging, analytics, notifications, and more.

---

# 🧩 **Features (v1.0)**

## 🔐 **1. Authentication & Authorization**
- JWT login + token validation filter  
- BCrypt password hashing  
- Stateless security  
- `@AuthenticationPrincipal` user injection  
- CustomUserDetailsService  
- Role: `USER` *(Admin roles coming soon)*  
- All protected API routes secured  

---

## ⚠️ **2. Global Exception Handling**
Standard JSON error format:

```json
{
  "timestamp": "",
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

User Fields:

username

email

password (hashed)

bio

avatarUrl

createdAt / updatedAt

Features:

Update profile

Delete profile

Fetch by ID

Fetch by username

Clean DTO (no password leaked)

📝 4. Post Module

Post Features:

Title, slug, content

Category

Tags

Comments

Likes count

Views

Status: DRAFT / PUBLISHED

createdAt / updatedAt

Supported Operations:

Create post

Update post

Publish post

Delete post

Fetch by ID

Pagination

Get posts by author

🗂 5. Category Module

Create

Update

Delete

Fetch by ID

Fetch by name

List all categories

Posts included inside response

🏷 6. Tag Module

Auto-create tags if they don’t exist

Many-to-many mapping

Returns tag names in responses

💬 7. Comment Module

Add comment

Update comment

Delete comment

List comments for a post (DESC)

Strict permission checks: only comment owner can modify/delete.

❤️ 8. Like Module

Toggle like/unlike

Unique user + post constraint

Count likes on a post

Included in PostResponse

📦 9. DTO System

Separate DTOs for every module:

UserRequest / UserResponse

PostRequest / PostResponse

CommentRequest / CommentResponse

CategoryRequest / CategoryResponse

TagRequest / TagResponse

LikeResponse

Ensures:
✔ clean API structure
✔ no infinite recursion
✔ frontend-friendly responses

📁 Project Structure
src/main/java/com/blog_backend
│
├── controller          # REST Controllers
├── service             # Interfaces
├── service.impl        # Implementations
├── repository          # JPA Repositories
├── model               # Entities
├── payload             # DTOs
├── security            # JWT, Filters, Security Config
└── exception           # Global Exception Handling

⚙️ Setup & Installation
1. Clone the Repository
git clone https://github.com/manudevtyagi05/blog-app-backend.git
cd blog-app-backend

2. Configure Database

application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update

3. Run the App
mvn spring-boot:run

🧭 API Endpoints (v1)
🔐 Auth
Method	Endpoint	Description
POST	/v1/auth/register	Register user
POST	/v1/auth/login	Login + JWT
👤 User
Method	Endpoint	Description
PUT	/v1/user/{id}	Update profile
DELETE	/v1/user/{id}	Delete profile
GET	/v1/user/id/{id}	Get user by ID
GET	/v1/user/name/{name}	Get user by name
📝 Post
Method	Endpoint	Description
POST	/v1/posts	Create post
PUT	/v1/posts/{id}	Update post
PUT	/v1/posts/{id}/publish	Publish post
GET	/v1/posts/{id}	Get post
GET	/v1/posts?page=&size=	Pagination
🗂 Category
Method	Endpoint
POST	/v1/categories
GET	/v1/categories/{id}
GET	/v1/categories/name/{name}
GET	/v1/categories
💬 Comment
Method	Endpoint
POST	/v1/comments/post/{postId}
PUT	/v1/comments/{id}
DELETE	/v1/comments/{id}
GET	/v1/comments/post/{postId}
❤️ Like
Method	Endpoint
POST	/v1/likes/post/{postId}
GET	/v1/likes/post/{postId}
🛣 Roadmap (Upcoming Versions)
🟩 v2.0 – Admin Panel + Roles + Media
🔐 Role-Based Access Control

ADMIN

AUTHOR

USER

🖼 Media Uploads

Post images

User avatars

Cloudinary / AWS S3

📝 Draft & Autosave

Auto-save posts

Draft mode

🚦 Approval Workflow

Author → Admin → Publish

🟧 v3.0 – Advanced Blog Features

Full-text search

Sort by likes/views/date

Trending tags

Analytics dashboard

🟥 v4.0 – Social + Notifications

Real-time notifications (likes/comments)

Reply to comment (threading)

Replies tree

🟪 v5.0 – Monetization + SEO + AI
💵 Monetization

Ads

Paid posts

Subscription plans

🌐 SEO

Meta title

Meta description

Auto SEO Tags

🤖 AI Features

Auto-suggest tags

Post summarizer

Grammar & tone correction

🛠 Improvements Planned for Current Version

Better error messages

Standard ErrorCode enums

Add validation annotations

Cache frequently used resources

Fix lazy-loading performance

Unit + Integration tests

Testcontainers

<div align="center">
⭐ If you like this project, don't forget to star the repo!
</div> ```

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
User Fields
username

email

password (hashed)

bio

avatarUrl

createdAt / updatedAt

Features
Update profile

Delete profile

Fetch by ID

Fetch by username

Clean DTO responses (no password exposure)

📝 4. Post Module
Post Features
Title, slug, content

Category

Tags

Comments

Likes count

Views

Status: DRAFT / PUBLISHED

createdAt / updatedAt

Supported Operations
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

Returns posts inside CategoryResponse

🏷 6. Tag Module
Auto-create tags if not existing

Many-to-many relationship

Returns tag names inside PostResponse

💬 7. Comment Module
Add comment

Update comment

Delete comment

List comments for a post (DESC order)

Strict permission enforcement: only owner may edit/delete

❤️ 8. Like Module
Toggle like/unlike

Enforced unique constraint: (user + post)

Like count

Included in PostResponse

📦 9. DTO System
Available DTOs
UserRequest / UserResponse

PostRequest / PostResponse

CommentRequest / CommentResponse

CategoryRequest / CategoryResponse

TagRequest / TagResponse

LikeResponse

Benefits
✔ Clean API structure
✔ No infinite recursion
✔ Frontend-friendly responses

📁 Project Structure
bash
Copy code
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
bash
Copy code
git clone https://github.com/manudevtyagi05/blog-app-backend.git
cd blog-app-backend
2. Configure Database
Add in application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
3. Run the Application
bash
Copy code
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

📝 Draft + Autosave
Auto-save editor

Draft mode

🚦 Approval Workflow
Author → Admin → Publish

🟧 v3.0 – Advanced Blog Features
Full-text search

Sort by likes / views / newest

Trending tags

Analytics dashboard

🟥 v4.0 – Social + Notifications
Real-time notifications

Threaded/reply comments

Replies tree

🟪 v5.0 – Monetization + SEO + AI
💵 Monetization
Ads

Paid posts

Subscriptions

🌐 SEO
Meta title

Meta description

Auto-SEO tags

🤖 AI Features
Auto-generate tags

Post summarizer

Grammar improvement

🛠 Improvements Planned for Current Version
Enhanced error messages

Standard ErrorCode enums

Add validation annotations

Cache frequently used data

Fix lazy-loading performance

Unit + Integration Tests

Testcontainers support

<div align="center">
⭐ If you like this project, don't forget to star the repo!

</div> ```roject, don't forget to star the repo!
</div> ```

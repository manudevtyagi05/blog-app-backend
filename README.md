📘 Blog Application Backend – Spring Boot (v1.0)

A fully modular, production-ready RESTful blog backend built with Spring Boot, Spring Security 6, JWT, and MySQL.
This project aims to evolve into a complete blogging platform with multi-user support, roles, content management, likes, tags, categories, comments, analytics, and more.

🧩 📌 Version History
🟦 Version 1.0 – Initial Release (Current Version)

This version includes the core backend foundation for a modern blog system.

✅ 1. Authentication & Authorization

JWT-based login

Token validation filter

BCrypt password hashing

CustomUserDetailsService

Stateless session management

Role: "USER" (Admin/Author roles planned in v2)

Protection of all sensitive routes

Automatic user extraction using @AuthenticationPrincipal

✅ 2. Exception Handling

Custom global exception handling with:

@ControllerAdvice

Structured error response:

{
  "timestamp": "",
  "success": false,
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Detailed message",
  "path": "/endpoint"
}


Handling:

ResourceNotFound

BadRequest

Validation

Unauthorized

Forbidden

Duplicate name/email

JWT errors (Expired, Invalid Token, Signature error)

✅ 3. User Module

Supports full CRUD for user profile:

User Entity Includes:

username

email

password

bio

avatar

createdAt

updatedAt

Features:

Update profile

Delete account

Fetch profile by ID/name

DTO-based clean responses (never returning password)

✅ 4. Post Module

Post Entity Features:

Title

Slug (auto-generated)

Content

Category

Tags

Comments

Views

Likes

Status (DRAFT / PUBLISHED)

Author mapping

createdAt / updatedAt

Supports:

Create post

Update post

Publish post

Delete post

Get post by ID

Pagination

Fetch by author

✅ 5. Category Module

Create category

Update category

Delete category

Get category by ID

Get category by name

List all categories

Posts mapped inside CategoryResponse

✅ 6. Tag Module

Auto-create tags if not existing

Process list of tag names

Many-to-many connection

Return list of tag names in PostResponse

✅ 7. Comment Module

Create comment

Update comment

Delete comment

Get all comments for a post (DESC order)

Strict permission: only comment owner can modify/delete

CommentResponse includes:

id

userId

username

postId

content

createdAt

✅ 8. Like Module

Toggle like/unlike

UniqueConstraint(user_id + post_id)

Count likes

Included in PostResponse (likes)

🔧 9. Data Transfer Objects (DTOs)

Created separately for every module:

UserRequest, UserResponse

PostRequest, PostResponse

CategoryRequest, CategoryResponse

TagResponse

CommentRequest, CommentResponse

LikeResponse (if needed)

This ensures clean, secure, front-end optimized API responses.

🧱 10. Project Architecture (Clean Code)
src/main/java/com.blog_backend
│
├── controller        # REST controllers
├── service           # Interfaces
├── service.impl      # Implementations
├── repository        # Spring Data JPA Repos
├── model             # Entities
├── payload           # DTOs
├── security          # JWT, Filters, Config
└── exception         # Global error handling

🚀 🔧 How to Run (Local Setup)
Prerequisites

Java 17+

Maven

MySQL

1. Clone the repo
git clone https://github.com/your-username/blog-backend.git
cd blog-backend

2. Configure MySQL in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Run
mvn spring-boot:run

🧭 API Overview (V1)
Auth Routes

POST /v1/auth/register

POST /v1/auth/login

User Routes

PUT /v1/user/{id}

DELETE /v1/user/{id}

GET /v1/user/id/{id}

GET /v1/user/name/{name}

Post Routes

POST /v1/posts

PUT /v1/posts/{id}

PUT /v1/posts/{id}/publish

GET /v1/posts/{id}

GET /v1/posts?page=&size=

Category Routes

POST /v1/categories

GET /v1/categories/{id}

GET /v1/categories/name/{name}

GET /v1/categories

Comment Routes

POST /v1/comments/post/{postId}

PUT /v1/comments/{id}

DELETE /v1/comments/{id}

GET /v1/comments/post/{postId}

Like Routes

POST /v1/likes/post/{postId}

GET /v1/likes/post/{postId}

🌟 📌 Upcoming Versions (Roadmap)
🟩 Version 2.0 – Admin Panel + Roles + Images
🔐 Role-Based Access Control (RBAC)

ADMIN

AUTHOR

USER

🖼 Media Storage

Upload post images

Upload user avatar

Support AWS S3 / Cloudinary / Local storage

📝 Drafts & Autosave

Save draft

Auto-save while writing

🚦 Post Approval Workflow

Authors write → Admin approves → Post publishes

🟧 Version 3.0 – Advanced Blog Features
📈 Analytics Dashboard

Total views

Popular posts

Most liked posts

Daily visitor stats

🔍 Search & Filters

Full-text search (title + content)

Filter by category

Filter by tag

Sort by date, views, likes

🏷 Advanced Tagging

Trending tags

Tag cloud API

🟥 Version 4.0 – Social + Notifications
🎯 Realtime Notifications

Someone liked your post

New comment

Reply-to-comment

Admin announcements

💬 Comment Replies (Threaded Comments)

Multi-level replying

Display comment tree

🟪 Version 5.0 – Monetization + SEO + AI Features
💵 Monetization

Ads

Paid posts

Subscriptions

🌐 SEO Tools

Meta title

Meta description

Auto-generate SEO tags

🤖 AI Features

Auto-suggest tags

Auto-summarize content

AI proofreading

🔥 Planned Improvements for Current Version
✔ Improve Exception Messages

More readable frontend-friendly messages.

✔ Add standard ErrorCodes.
✔ Add validation annotations

@NotNull, @Email, @Length, etc.

✔ Improve PostResponse to avoid recursion

Lazy loading optimization.

✔ Add caching

For categories, tags, post lists.

✔ Add tests

Unit tests (JUnit)

Integration tests

Testcontainers (optional)

🏁 Final Note

This README represents a professional-quality project roadmap suitable for GitHub, team onboarding, or portfolio use.

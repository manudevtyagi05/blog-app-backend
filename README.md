# 📝 Blog Management System – RESTful API (Java Spring Boot)

A backend RESTful API built with **Java, Spring Boot, and MySQL**, designed to manage users, blog posts, categories, and comments. Follows clean architecture with DTOs, service layers, and proper exception handling.

## 🚀 Features

- CRUD for Users, Posts, Categories, and Comments
- Search Posts by Title
- Create Post by User & Category
- Global Exception Handling
- Consistent API Responses
- DTO + ModelMapper Pattern
- Postman-tested REST APIs

## 🛠️ Tech Stack

- Java 17, Spring Boot, Maven
- MySQL, Spring Data JPA
- Postman, Lombok, ModelMapper

## 📁 Modules

- **User Module**: `/api/users`
- **Post Module**: `/api/posts`, `/api/user/{userId}/posts`, `/api/category/{categoryId}/posts`
- **Category Module**: `/api/categories`
- **Comment Module**: `/api/post/{postId}/comments`

## 🔗 Example Endpoints

```http
POST   /api/users/
POST   /api/categories/
POST   /api/user/{userId}/category/{categoryId}/posts
GET    /api/posts/search/{keywords}
POST   /api/post/{postId}/comments

API Integration
The app expects a backend API with the following endpoints:

Authentication
POST /api/auth/register - Register new user
POST /api/auth/login - Login user
Posts
GET /api/posts - List posts (supports pagination, search, category filter)
GET /api/posts/:id - Get post details
POST /api/posts - Create post (authenticated)
PUT /api/posts/:id - Update post (authenticated)
DELETE /api/posts/:id - Delete post (authenticated)
Likes
POST /api/posts/:id/like - Toggle like (authenticated)
Comments
GET /api/posts/:id/comments - Get post comments
POST /api/posts/:id/comments - Add comment (authenticated)
Categories
GET /api/categories - List all categories
See src/api/ directory for detailed request/response types.

Environment Variables

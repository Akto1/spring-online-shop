# Spring Online Shop

Backend for online store built with Spring Boot.

## Features
- JWT Authentication
- Role-Based Authorization
- Role-Checked Requests
- Hashing Password to Bytes
- Product - Category - Order CRUD
- Validation
- Pagination

## Stack
Java
Spring Boot
PostreSQL (pgAdmin4)
Spring Security
Spring JPA

## Endpoints
/auth/register - Register to the Shop
/auth/login - Log In to account by given JWT 
/product/create - Create Product
/category/create - Create category
/order/create/ - Create order 
/give/admin/id/{id} - Give ROLE_ADMIN to User by id (Only Entity ROLE_ADMIN can)

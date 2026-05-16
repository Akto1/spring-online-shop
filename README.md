# Spring Online Shop

Backend for online store built with Spring Boot.

# Features
- Role-Based Authorization
- CRUD operations for Products, Categories and Orders
- Validation
- Pagination

# Stack
Java
Spring Boot
PostgreSQL 
Spring Security
Spring Data JPA

# Security
- JWT Authentication
- Role-Checked Requests
- Password Encrypting (BCrypt)

# Endpoints
/auth/register - Register to the Shop
/auth/login - Log In to account by given JWT 
/product/create - Create Product
/category/create - Create category
/order/create/ - Create order 
/give/admin/id/{id} - Give ROLE_ADMIN to User by id (Only users with  ROLE_ADMIN can access this endpoint)

# Run project
1. Clone repository
2. Configure PostgreSQL
3. Set application.properties (SECRET_KEY, EXPIRATION_TIME)
4. Run Spring Boot Application file
5. 

Серверная часть для интернет-магазина, созданного с помощью Spring Boot.

# Функции
- Авторизация на основе ролей
- Операции CRUD для продуктов, категорий и заказов
- Проверка подлинности
- Разбивка на страницы

# Стек
Java
Spring Boot
PostgreSQL 
Spring Security
Spring Data JPA

# Безопасность
- Аутентификация JWT
- Запросы с проверкой ролей
- Шифрование паролей (BCrypt)

# Конечные точки
/auth/register - Регистрация в магазине
/auth/login - Вход в учетную запись с помощью указанного JWT 
/product/create - Создать продукт
/category/create - Создать категорию
/order/create/ - Создать заказ
/give/admin/id/{id} - Присвоить пользователю ROLE_ADMIN по id (Только пользователи с ROLE_ADMIN могут получить доступ к этому запросу)

# Запустить проект
1. Клонировать репозиторий
2. Настроить PostgreSQL
3. Задать application.properties (SECRET_KEY, EXPIRATION_TIME)
4. Запустить файл  Spring Boot Application

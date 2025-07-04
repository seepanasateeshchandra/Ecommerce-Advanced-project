# 🛒 Advanced eCommerce Backend (Spring Boot Monolithic)

An **end-to-end monolithic eCommerce backend** project built with Java, Spring Boot, Spring Security (JWT), and JPA. This project simulates a real-world eCommerce application with features like user authentication, product management, cart, orders, payments, inventory management, dashboards, and role-based access.

---

## 🔧 Tech Stack

* **Language**: Java 17+
* **Framework**: Spring Boot 3.x
* **Security**: Spring Security with JWT Authentication
* **Database**: MySQL / PostgreSQL / H2 (configurable)
* **ORM**: Spring Data JPA + Hibernate
* **Validation**: Jakarta Validation (JSR 380)
* **DTO Mapping**: MapStruct (or manual mapping)
* **Documentation**: Swagger UI + OpenAPI
* **Build Tool**: Maven
* **Architecture**: Monolithic, Layered (Controller → Service → Repository)

---

## 🔐 Authentication Module

* JWT-based authentication (Register/Login)
* Role-based access (`ADMIN`, `USER`)
* Password encryption using BCrypt
* Endpoints:

  * `POST /api/auth/register`
  * `POST /api/auth/login`

---

## 👤 User Module

* Register new users
* Secure login with JWT
* View personal info and profile
* Role-based access control

---

## 🛍️ Product Module

* Admin can create/update/delete products
* Users can browse all products
* Includes product DTOs and validation
* Endpoints:

  * `GET /api/products`
  * `POST /api/products` (ADMIN only)
  * `PUT /api/products/{id}` (ADMIN only)
  * `DELETE /api/products/{id}` (ADMIN only)

---

## 🛒 Cart Module

* Users can:

  * Add products to cart
  * View cart
  * Remove items from cart
* Each user has a single active cart
* Cart sync with product availability

---

## 📦 Order Module

* Convert cart to order
* Save ordered items and quantities
* Update inventory automatically
* View order history
* Order DTOs and mapping

---

## 💳 Payment Module

* Simulates payment after placing order
* Stores payment info linked with order
* Basic success simulation
* Timestamped payment tracking

---

## 🧮 Inventory Module

* Track stock quantity of each product
* Inventory sync:

  * ⬇ Decrease quantity on order
  * ⬆ Increase on cancel (if implemented)
* Prevent order if stock not available

---

## 📊 Admin Dashboard

* Total users
* Total products
* Total orders
* Total revenue
* Admin-only access
* Endpoint: `GET /api/admin/dashboard`

---

## 📋 User Dashboard

* View profile info
* Recent orders
* Cart items
* Last payment summary
* Endpoint: `GET /api/user/dashboard`

---

## 🧾 Swagger API Docs

* Accessible at `/swagger-ui/index.html`
* Includes:

  * JWT token authorization
  * All REST endpoints with request/response models

---

## 🚀 How to Run

1. Clone the repo
   `git clone https://github.com/your-username/ecommerce-backend`

2. Set up your database in `application.properties`

3. Run the Spring Boot application
   `mvn spring-boot:run`

4. Access Swagger docs
   `http://localhost:8080/swagger-ui/index.html`

---

## ✅ Features Summary

| Feature        | Description                       |
| -------------- | --------------------------------- |
| 🧍 User Auth   | Register/Login, Role-based access |
| 🛒 Cart        | Add/Remove items, view cart       |
| 🛍️ Products   | Admin CRUD, user view             |
| 📦 Orders      | Convert cart to order             |
| 💳 Payment     | Simulate payment with timestamps  |
| 🧮 Inventory   | Stock management, sync with order |
| 📊 Dashboards  | Real-time user/admin stats        |
| 🔐 JWT Secured | All endpoints protected           |
| 📖 Swagger UI  | Full API docs & testing UI        |

---

## 📂 Folder Structure

src/
├── main/
│   ├── java/com/example/
│   │   └── ecommerce/
│   │       ├── config/                # Security & Swagger Configuration
│   │       ├── controller/            # REST API Controllers
│   │       ├── dto/                   # Data Transfer Objects
│   │       ├── entity/                # JPA Entity Classes
│   │       ├── exception/             # Custom Exceptions & Handlers
│   │       ├── repository/            # JPA Repositories
│   │       ├── security/              # JWT & Authentication Filters
│   │       ├── service/               # Service Interfaces & Implementations
│   │       └── EcommerceApplication.java  # Main class
│   └── resources/
│       ├── application.properties     # DB config, Swagger, etc.
│       └── static/ & templates/       # (Optional for frontend)
├── test/                              # Unit & Integration Tests



**📌 Final Note**

1. This monolithic eCommerce backend simulates a production-grade real-world system. It covers:
2. Full JWT-based authentication & role management
3. Clean DTO → Entity mapping
4. Business logic separation
5. Realistic eCommerce workflows (cart, order, payment)
6. Admin/User dashboards
7. Inventory stock sync
8. Swagger-powered API exploration

**This is the Swagger screen shoots of This Project**

![Screenshot 2025-07-03 163434](https://github.com/user-attachments/assets/93c0ea23-a873-463e-8309-15bc974384b4)
![Screenshot 2025-07-03 163513](https://github.com/user-attachments/assets/31fb09f1-3e5f-4f02-ad68-ce7b02f0540e)
![Screenshot 2025-07-03 163535](https://github.com/user-attachments/assets/3b62ba9f-ee0a-452f-98f4-3d071690be4a)

**This Registration Page of User in PostMan :**
![Screenshot 2025-07-03 183855](https://github.com/user-attachments/assets/3e9bf18d-f3c1-4890-8953-88aaf5224e91)

**This is login Page Of Who are Register with emaild and password**
![Screenshot 2025-07-04 095648](https://github.com/user-attachments/assets/b6b26a91-00ee-4a35-9980-d3e425c518c7)

**This is User Module Photo in This see the Details about UserDetails with User only with JWT Token With Token it will Not allow**
![Screenshot 2025-07-04 095648](https://github.com/user-attachments/assets/0d94a33c-a6f0-4af6-bfdb-2bc94064d12e)


![Screenshot 2025-07-04 185745](https://github.com/user-attachments/assets/0214b42d-8937-4893-9643-65e485992c54)
















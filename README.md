# E-Commerce Platform

## Project Overview
A simple microservices-based E-Commerce backend built with Spring Boot and Spring Cloud.  
It includes:

- **Product Service** – Manages products and inventory
- **Order Service** – Places orders and communicates with Product Service via Feign
- **API Gateway** – Routes requests to services
- **Eureka Server** – Service discovery

---
## Services & Methods

### Product Service (8081)

| HTTP Method | Endpoint | Description |
|------------|---------|-------------|
| POST       | /products | Add a new product |
| GET        | /products | Get all products |
| GET        | /products/{id} | Get product by ID |
| PUT        | /products/{id} | Update product by ID |
| DELETE     | /products/{id} | Delete product by ID |
| PUT        | /products/reduce/{id}?quantity={qty} | Reduce product quantity (used by Order Service) |

### Order Service (8082)

| HTTP Method | Endpoint | Description |
|------------|---------|-------------|
| POST       | /orders | Create a new order for the given product and quantity |
| GET        | /orders/{id} | Retrieve order details by order ID |
---

## How to Run
1. Start **Eureka Server** (port 8761)
2. Start **Product Service** (port 8081)
3. Start **Order Service** (port 8082)
4. Start **API Gateway** (port 8080)
---

## Access all services via API Gateway:
- `/products/**` → Product Service
- `/orders/**` → Order Service

---


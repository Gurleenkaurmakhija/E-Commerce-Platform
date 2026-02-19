# E-Commerce Platform

## Project Overview
A simple microservices-based E-Commerce backend built with Spring Boot and Spring Cloud.  
It includes:

- **Product Service** – Manages products and inventory
- **Order Service** – Places orders and communicates with Product Service via Feign
- **API Gateway** – Routes requests to services
- **Eureka Server** – Service discovery

---

## Services & Endpoints

### Product Service (`8081`)
- **Add Product:** `POST /products`  
  Request: `{"name":"Laptop","price":50000,"quantity":10}`
- **Get All Products:** `GET /products`
- **Get Product By ID:** `GET /products/{id}`
- **Update Product:** `PUT /products/{id}`
- **Delete Product:** `DELETE /products/{id}`
- **Reduce Product Quantity:** `PUT /products/reduce/{id}?quantity=2`

### Order Service (`8082`)
- **Place Order:** `POST /orders/{productId}?quantity=2&totalAmount=100000`
- **Get Order By ID:** `GET /orders/{id}`

---

## How to Run
1. Start **Eureka Server** (port 8761)
2. Start **Product Service** (port 8081)
3. Start **Order Service** (port 8082)
4. Start **API Gateway** (port 8080)

Access all services via API Gateway:
- `/products/**` → Product Service
- `/orders/**` → Order Service

---


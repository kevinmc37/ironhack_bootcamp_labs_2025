# ⚔️ RPG Game Backend Engine (Ironhack Final Project)

[English Version Below](#english-version)

---

## 🇪🇸 Versión en Castellano

Un motor de backend robusto y de nivel empresarial diseñado como API REST para el ecosistema de un videojuego de rol (RPG) o MMO. La plataforma gestiona lógicas de dominio complejas que incluyen la progresión de jugadores, asignación dinámica de inventarios, especialización de ítems, estructuras de mercado y un sistema de autenticación de alta seguridad.

Este proyecto representa la culminación del **Bootcamp de Desarrollo Web Full-Stack en Ironhack**, demostrando la implementación avanzada de patrones de diseño empresariales en Java, modelado de bases de datos relacionales y sistemas de seguridad basados en tokens.

### 🚀 Aspectos Técnicos Destacados

*   **Arquitectura de Datos Avanzada con JPA:** Implementa persistencia relacional utilizando **Spring Data JPA**. Utiliza técnicas de mapeo avanzadas como `InheritanceType.JOINED` para modelar entidades altamente especializadas (la clase `Item` hereda en tipos distintos como `Equipment` y `Resource`), optimizando las restricciones de la base de datos y las consultas.
*   **Stack de Seguridad Empresarial a Medida:** Asegurado mediante **Spring Security** y **JSON Web Tokens (JWT)**. La autenticación y la autorización están completamente segregadas a través de filtros personalizados (`CustomAuthenticationFilter` y `CustomAuthorizationFilter`), con encriptación segura de contraseñas mediante `BCryptPasswordEncoder`.
*   **Control de Acceso Basado en Roles (RBAC):** Restringe los endpoints según capacidades administrativas jerárquicas claras (`ROLE_USER`, `ROLE_ADMIN`), asegurando que los jugadores solo modifiquen su propio entorno mientras los administradores mantienen el control total del sistema.
*   **Desacoplamiento Estricto mediante DTOs:** El transporte de datos está completamente separado de las entidades de la base de datos mediante Objetos de Transferencia de Datos (`PlayerRequestDTO`, `ItemRequestDTO`, etc.), evitando la exposición innecesaria de datos internos.
*   **Sistema Centralizado de Gestión de Errores:** Implementa un manejador global de excepciones (`GlobalExceptionHandler`) utilizando `@ControllerAdvice` para capturar anomalías en tiempo de ejecución (`PlayerNotFoundException`, `BadRequestException`) y transformarlas en respuestas API estructuradas y seguras.
*   **Entorno Demo Automático:** Cuenta con una secuencia de inicialización automática de datos (`DataLoader` y `GameDataInitializer`) que, al arrancar la aplicación, precarga usuarios administradores, roles estándar, base de datos de ítems y pools de equipamiento inicial.

### 🛠️ Arquitectura y Tecnologías

*   **Core Backend:** Java 17 y Spring Boot Framework
*   **Seguridad:** Spring Security, JWT (Json Web Tokens), Encriptación BCrypt
*   **Persistencia:** Spring Data JPA, Hibernate ORM, MySQL / MariaDB
*   **Patrón Arquitectónico:** Arquitectura en Capas (`Controller` ➔ `Service` ➔ `Repository` ➔ `Model`) con mapeos DTO y Excepciones personalizadas.

---

## 🇬🇧 English Version

A robust, enterprise-grade RESTful API designed as the core backend engine for an RPG/MMO video game ecosystem. This platform handles complex domain logic including player progression, dynamic inventory allocation, item specialization, marketplace structuring, and high-security user authentication.

This project represents the culmination of the **Ironhack Full-Stack Web Development Bootcamp**, showcasing advanced implementation of enterprise Java design patterns, relational database modeling, and token-based security systems.

### 🚀 Key Technical Highlights

*   **Advanced JPA Data Architecture:** Implements relational data persistence using **Spring Data JPA**. It leverages advanced mapping techniques such as `InheritanceType.JOINED` to model highly specialized entities like `Item` inheriting into distinct types (`Equipment` and `Resource`), optimizing database constraints and query structures.
*   **Custom Enterprise Security Stack:** Secured using **Spring Security** paired with **JSON Web Tokens (JWT)**. Authentication and authorization are cleanly segregated via custom filters (`CustomAuthenticationFilter` and `CustomAuthorizationFilter`), featuring secure password encryption through `BCryptPasswordEncoder`.
*   **Role-Based Access Control (RBAC):** Restricts endpoints according to distinct hierarchical administrative capabilities (`ROLE_USER`, `ROLE_ADMIN`), ensuring players can only modify their own scope while administrators maintain total system dominion.
*   **Strict Decoupling via DTO Pattern:** Data transport is cleanly separated from database entities using Data Transfer Objects (`PlayerRequestDTO`, `ItemRequestDTO`, etc.) preventing unnecessary data exposure and enforcing predictable JSON payloads.
*   **Centralized Fault-Tolerant System:** Implements a global middleware handler (`GlobalExceptionHandler`) utilizing `@ControllerAdvice` to capture domain-specific runtime anomalies (`PlayerNotFoundException`, `BadRequestException`) and pipe them into structured, safe API responses.
*   **Seeded Demo Environment:** Features an automated data bootstrap sequence (`DataLoader` & `GameDataInitializer`) ensuring that upon application launch, the database pre-allocates administrative users, standard roles, core item databases, and starting equipment pools automatically.

### 🛠️ Architecture & Technologies Used

*   **Core Backend:** Java 17 & Spring Boot Framework
*   **Security Framework:** Spring Security, JWT, BCrypt Encoders
*   **Data & Persistence:** Spring Data JPA, Hibernate ORM, MySQL / MariaDB
*   **Design Architecture:** Layered Architecture (`Controller` ➔ `Service` ➔ `Repository` ➔ `Model`) paired with DTO mappings and custom Exceptions.

---

### 🔌 API REST Endpoints (Overview / Resumen)

| Method | Endpoint | Description (ES) | Description (EN) | Access |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/login` | Inicio de sesión e emisión de JWT | Handles token issuance via login | Public |
| `POST` | `/api/users/save` | Registro de nuevos usuarios | Registers a new user account | Public / User |
| `POST` | `/api/roles/addtouser` | Asignar rol a un usuario | Attaches security roles to a user | **Admin Only** |
| `GET` | `/api/players` | Listar todos los personajes | Fetches all registered profiles | User / Admin |
| `POST` | `/api/players` | Crear personaje para el usuario | Provisions a new character context | User / Admin |
| `GET` | `/api/items` | Ver compendio global de ítems | Returns the full compendium of items | User / Admin |
| `POST` | `/api/items` | Crear nuevos ítems del juego | Creates new specialized items | **Admin Only** |
| `POST` | `/api/inventories/add-item` | Añadir ítem a un inventario | Attaches an item instance to a player | User / Admin |
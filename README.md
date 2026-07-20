![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | Relaciones e Herencia en JPA

### Instrucciones

1. Haz un fork de este repositorio.
2. Clona tu fork en tu máquina local.
3. Resuelve los desafíos.

## Entregables

- Crea una aplicación limpia de Spring Boot.
- Al terminar, añade tu solución a git.
- Luego haz commit y push al repositorio en GitHub.
- Crea un pull request y pega el enlace del pull request en el campo de entrega del Student Portal.

## Introducción

Ahora has aprendido a:
- Modelar relaciones usando anotaciones JPA
- Modelar herencia en tablas de bases de datos
- Usar objetos embebidos dentro de entidades
- Controlar la carga de datos con tipos de fetch

En este lab, aplicarás estos conceptos modelando varios sistemas con diferentes tipos de relaciones.

## Objetivos

Al final de este lab, deberías ser capaz de:

- Diseñar entidades JPA usando mapeos One-to-One, One-to-Many y Many-to-Many
- Crear objetos embebidos dentro de entidades
- Mapear herencia usando JPA
- Gestionar Lazy y Eager fetching
- Aplicar buenas prácticas de JPA para un código limpio y mantenible

## Escenario Proporcionado

Trabajarás en tres módulos diferentes:

### 1. Sistema de Contactos de Relaciones Públicas

Modela el sistema de contactos para una empresa de relaciones públicas.

**Entidades a Crear:**
- `Contact`
- `Name`

**Requisitos:**
- Crea un objeto embebible `Name` con los siguientes campos:
    - `salutation` (por ejemplo, Mr., Mrs., Dr.)
    - `firstName`
    - `middleName`
    - `lastName`
- Embebe el objeto `Name` dentro de la entidad `Contact`.
- `Contact` debe tener:
    - `id` (auto-generado)
    - `company`
    - `title`
    - `name` (el `Name` embebido)

### 2. Sistema de Gestión de Divisiones de una Asociación de Enfermería

Modela un sistema para una Asociación de Enfermería con Divisiones y Miembros.

**Entidades a Crear:**
- `Association`
- `Division`
- `Member`

**Requisitos:**

- Una `Association` debe tener:
    - `id` (auto-generado)
    - `name` (por ejemplo, "Asociación de Enfermería de España")
    - Una lista de divisiones.

- Una `Division` debe tener:
    - `id` (auto-generado)
    - `name`
    - `district`
    - Un presidente.
    - Una lista de miembros.

- Un `Member` debe tener:
    - `id` (auto-generado)
    - `name`
    - `status` (enum: ACTIVE, LAPSED)
    - `renewalDate` (LocalDate)

**Importante:**
- Usa `@Enumerated(EnumType.STRING)` para el `status`.
- Establece un tipo de fetch apropiado para las colecciones.
- Crea y guarda **una Asociación** que contenga **7 Divisiones**, cada una con al menos un Miembro.

### 3. Sistema de Gestión de Eventos

Modela una aplicación de gestión de eventos.

**Entidades a Crear:**
- `Event`
- `Conference`
- `Exhibition`
- `Guest`
- `Speaker`

**Requisitos:**
- `Event` debe tener:
    - `id` (auto-generado)
    - `title`
    - `date` (LocalDate)
    - `duration` (Integer)
    - `location`
    - Una lista de invitados.

- `Guest` debe tener:
    - `id` (auto-generado)
    - `name`
    - `status` (enum: ATTENDING, NOT_ATTENDING, NO_RESPONSE)

- `Conference` debe tener:
    - Una lista de ponentes.

- `Speaker` debe tener:
    - `id` (auto-generado)
    - `name`
    - `presentationDuration` (Integer)

**Importante:**
- Usa `@Inheritance(strategy = InheritanceType.X)` donde sea apropiado.
- Crea las asociaciones necesarias sin que se te diga explícitamente el tipo. Piensa en cómo deberían estar conectadas las tablas.
- Usa `@Enumerated(EnumType.STRING)` para enums.
- Modela tablas de unión donde sea necesario.

## Reto Opcional: Sistema de Gestión de Tareas

(¡Recomendado si terminas temprano!)

Modela un sistema simple de gestión de tareas con las siguientes especificaciones:

**Entidades a Crear:**
- `Task`
- `BillableTask`
- `InternalTask`

**Requisitos:**
- Una `Task` debe tener:
    - `id` (auto-generado)
    - `title`
    - `dueDate` (LocalDate)
    - `completed` (boolean)

- `BillableTask` debe tener:
    - `hourlyRate` (BigDecimal)

- `InternalTask` no tiene campos adicionales.

**Importante:**
- Usa `@Inheritance(strategy = InheritanceType.X)` donde corresponda.

## Tareas

1. Define todas las entidades con las anotaciones JPA apropiadas.
2. Usa `@Inheritance(strategy = InheritanceType.X)` donde sea necesario.
3. Crea las interfaces de repositorio necesarias para cada entidad.
4. Usa CommandLineRunner o una clase @Configuration para crear y guardar al menos 3 entradas de ejemplo por entidad (o grupo lógico).
5. (Opcional) Añade métodos de consulta simples en los repositorios:
    - Buscar divisiones por distrito
    - Buscar invitados por estado

## Preguntas Bonus

Responde estas preguntas en un archivo `bonus-questions.txt` dentro de tu repo:

1. Menciona 3 tareas que se pueden realizar con SQL nativo pero que son difíciles o imposibles con JPQL.
2. Explica por qué podrías preferir usar SQL nativo en proyectos del mundo real.

## Preguntas Frecuentes

<details>
  <summary> ¿Puedo usar CommandLineRunner para insertar datos de ejemplo?</summary>

<br>

¡Sí! Se recomienda. También puedes usar controladores REST más adelante si lo prefieres.

</details>

<details>
  <summary> ¿Debería usar DTOs y servicios ya?</summary>

<br>

¡Todavía no es necesario! Concéntrate en modelar las entidades y relaciones.

</details>

<details>
  <summary> ¿Cómo elijo entre FetchType.LAZY o FetchType.EAGER?</summary>

<br>

- Usa **LAZY** para colecciones a menos que necesites absolutamente los datos de inmediato.
- Usa **EAGER** con cuidado para relaciones simples de uno a uno.

</details>

:dart: ¡Tómate tu tiempo, modela las relaciones con cabeza y construye una base sólida para aplicaciones más complejas en el futuro!

:white_check_mark:  **No se regala nada** (no se dan pistas directas sobre OneToOne, OneToMany).  <br>
:white_check_mark:  **Association** está correctamente incluida.  <br>
:white_check_mark:  **El estudiante debe descubrir** las relaciones por sí mismo.  <br>
:white_check_mark:  **Listo para copiar-pegar en GitHub o en plataformas de aula**.
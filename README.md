![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | Introducción a JPA con Spring Data

### Instrucciones

1. Haz fork de este repositorio.
2. Clona tu fork en tu máquina local.
3. Resuelve los retos propuestos.

## Entregables

- Al terminar, añade tu solución a git.
- Luego haz commit y push al repositorio en GitHub.
- Crea un pull request y pega el enlace del pull request en el campo de entrega del Student Portal.

## Introducción

Ya aprendiste a crear objetos entidad y a usar repositorios JPA para consultar datos. En este lab, aplicarás esos conceptos modelando un sistema de reservas de vuelos.

## Objetivos

Al finalizar este lab, deberías poder:
- Diseñar entidades JPA usando valores enum y atributos básicos
- Configurar y utilizar interfaces `JpaRepository`
- Crear y usar consultas simples derivadas de nombres de métodos
- Escribir modelos limpios y mantenibles siguiendo buenas prácticas de JPA

## Conjunto de Datos

Vamos a representar el sistema de reservas usando datos del lab de aerolínea (Lab 3.01). Tu misión es diseñar las clases y la estructura de base de datos para las siguientes entidades:

- `Customer`
- `Flight`
- `FlightBooking`

También crearás un enum `CustomerStatus`.

## Entregables

Necesitas modelar y mapear lo siguiente:

### 1. Enum `CustomerStatus`
Crea un enum con estos valores:

```java
GOLD, SILVER, NONE
```

Úsalo dentro de tu entidad `Customer`. No olvides anotar el campo con `@Enumerated(EnumType.STRING)`.

### 2. Entidad `Customer`

Atributos:
- ID único autogenerado
- Nombre (String)
- Estado (enum `CustomerStatus`)
- Total de millas voladas (Integer)

Usa las anotaciones adecuadas para mapearlo como una tabla.

### 3. Entidad `Flight`

Atributos:
- ID autogenerado
- Número de vuelo (String)
- Aeronave (String)
- Número total de asientos (Integer)
- Distancia del vuelo (Integer)

Mapéala correctamente con anotaciones JPA.

### 4. Entidad `FlightBooking`

Atributos:
- ID autogenerado
- ID del cliente (Integer)
- ID del vuelo (Integer)

> Por ahora, **no** uses `@ManyToOne`. Solo guarda las claves foráneas como campos. Introduciremos relaciones entre entidades en una lección futura.

## Tareas

1. Define las cuatro clases anteriores con las anotaciones correspondientes.
2. Crea las interfaces `JpaRepository` correspondientes para cada entidad.
3. Usa `CommandLineRunner` para crear al menos 3 entradas de ejemplo por tabla. Ejemplo en la clase Main (se puede hacer desde una clase @Configuration también):
	```java
	@SpringBootApplication
	public class DemoApplication {

		public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
		}

		@Bean
		CommandLineRunner run(CustomerRepository customerRepo,
							FlightRepository flightRepo,
							FlightBookingRepository bookingRepo) {
			return args -> {
				Customer alice = customerRepo.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
				Flight flight = flightRepo.save(new Flight("AB123", "Boeing 747", 300, 400));
				bookingRepo.save(new FlightBooking(alice.getId(), flight.getId()));
			};
		}
	}
	```
4. Añade un método de consulta en `CustomerRepository` para buscar clientes por estado.
5. Añade un método de consulta en `FlightBookingRepository` para buscar reservas por ID de cliente.


## Práctica Extra 

Si terminas temprano, prueba estas tareas adicionales:

- Añade un método en `FlightBookingRepository` para buscar reservas por ID de vuelo.
- Añade un método en `CustomerRepository` para buscar clientes con más de 100.000 millas.


## Preguntas Frecuentes

<details>
  <summary> ¿Puedo usar CommandLineRunner para insertar mis datos?</summary>

¡Sí! Puedes usar `@Bean CommandLineRunner` para insertar algunas entradas de prueba al iniciar la aplicación. O usar Postman para hacer peticiones POST a través de un controlador REST.

</details>

<details>
  <summary> ¿Debo definir relaciones entre las entidades?</summary>

Todavía no. Por ahora, solo guarda los IDs (`customerId`, `flightId`) directamente en `FlightBooking`. Veremos `@ManyToOne` y otras relaciones en una lección futura.

</details>

<details>
  <summary> ¿Qué pasa si tengo errores al guardar datos?</summary>

Asegúrate de que tus clases entidad tengan:
- Un constructor vacío
- Tipos de datos correctos
- Anotaciones `@Entity`, `@Id` y `@GeneratedValue` donde sea necesario

</details>
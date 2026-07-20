![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | Fundamentos de SpringBoot

## **Instrucciones**

1. Haz un **fork** de este repositorio.  
2. Clona tu **fork** en tu máquina local.  
3. Resuelve los desafíos.  

## Entregables  

- Una vez completado, agrega tu solución a **git**.  
- Luego, haz **commit** en git y **push** a tu repositorio en GitHub.  
- Crea un **pull request** y pega el enlace del pull request en el campo de entrega en el **Portal del Estudiante**.

## Tareas

1. **Crea una aplicación Spring Boot** utilizando **Spring Initializr** con las siguientes dependencias:
   - **Spring Web**
   - **Spring Boot DevTools**

2. **Crea una clase `GreetingController`** que contenga los siguientes endpoints:
   - **`/hello`** → Retorna `"Hello World!"`
   - **`/hello/{name}`** → Retorna `"Hello {name}!"` donde `{name}` es una variable de ruta.
   - **`/add/{num1}/{num2}`** → Retorna la **suma** de `num1` y `num2`.
   - **`/multiply/{num1}/{num2}`** → Retorna el **producto** de `num1` y `num2`.

3. **Crea una clase `WeatherService`** con los siguientes métodos:
   - **Obtener la temperatura actual** → Simulada con un número aleatorio entre **-10 y 40**.
   - **Obtener la condición climática** → Devuelve aleatoriamente uno de los siguientes valores: `"Sunny"`, `"Rainy"`, `"Cloudy"`, `"Windy"`.
   - **Obtener la velocidad del viento** → Simulada con un número aleatorio entre **0 y 100**.

4. **Crea una clase `WeatherController`** que utilice **inyección de dependencias por constructor** para recibir el `WeatherService` y exponga los siguientes endpoints:
   - **`/weather/temperature`** → Retorna la temperatura actual.
   - **`/weather/condition`** → Retorna la condición climática actual.
   - **`/weather/wind`** → Retorna la velocidad actual del viento.
   - **`/weather/all`** → Retorna **toda la información meteorológica** en una sola respuesta.

5. **Crea una clase `TimeService`** con los siguientes métodos:
   - **Obtener la hora actual**.
   - **Obtener la fecha actual**.
   - **Obtener el día actual de la semana**.

6. **Crea una clase `TimeController`** que utilice **inyección de dependencias por constructor** para recibir el `TimeService` y exponga los siguientes endpoints:
   - **`/time`** → Retorna la **hora actual**.
   - **`/date`** → Retorna la **fecha actual**.
   - **`/day`** → Retorna el **día actual de la semana**.
   - **`/all`** → Retorna **toda la información temporal** en una sola respuesta.

### **Recuerda:**

- Usa una **estructura de paquetes adecuada**.  
- **Usa inyección de dependencias por constructor** en lugar de `@Autowired`.  
- **Prueba todos los endpoints** en tu navegador o en **Postman**.  
- **Incluye manejo de errores adecuado**.  
- Usa **nombres de variables y métodos significativos**.
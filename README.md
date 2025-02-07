# 🚀 CRUD API con Spring Boot y MySQL

Este proyecto es una aplicación API RESTful que implementa operaciones CRUD para gestionar estudiantes. La aplicación utiliza Spring Boot para el backend, MySQL para la persistencia de datos y Thymeleaf para la interfaz web.

## Características

- **Operaciones CRUD:** Crear, leer, actualizar y eliminar estudiantes.
- **API RESTful:** Endpoints para la integración vía JSON.
- **Interfaz Web:** Gestión de estudiantes mediante vistas renderizadas con Thymeleaf.
- **Persistencia:** Uso de Spring Data JPA para interactuar con MySQL.
- **Validación de Datos:** Validación de formularios a nivel de aplicación.

## Tecnologías Utilizadas

- Java 11+
- Spring Boot
- Spring Data JPA
- MySQL
- Thymeleaf
- Maven
- Lombok

## Requisitos Previos

- JDK 11 o superior.
- MySQL instalado y configurado.
- Maven para la gestión de dependencias.
- 
## 📡 Uso de POSTMAN (testear API)

Para probar la API con Postman, sigue estos pasos:

1. **Configurar una nueva petición o colección en Postman.**

2. **Listar estudiantes:**
   - **Método:** GET  
   - **URL:** `http://localhost:8080/api/v1/student`  
   - Haz clic en "Send" para visualizar la lista de estudiantes.

3. **Obtener un estudiante por ID:**
   - **Método:** GET  
   - **URL:** `http://localhost:8080/api/v1/student/1`  
     (Reemplaza `1` por el ID deseado)
   - Haz clic en "Send" para ver la información del estudiante.

4. **Crear un estudiante:**
   - **Método:** POST  
   - **URL:** `http://localhost:8080/api/v1/student`  
   - En la pestaña **Body**, selecciona `raw` y `JSON`, e ingresa un JSON similar al siguiente:
     ```json
     {
       "primerNombre": "Ejemplo",
       "segundoNombre": "ejemplo2",
       "email": "ejemplo@correo.com"
     }
     ```
   - Haz clic en "Send" para crear el nuevo estudiante.

5. **Actualizar un estudiante:**
   - **Método:** PUT  
   - **URL:** `http://localhost:8080/api/v1/student/1`  
     (Reemplaza `1` por el ID del estudiante a actualizar)
   - En la pestaña **Body**, selecciona `raw` y `JSON`, e ingresa un JSON con los datos actualizados:
     ```json
     {
       "primerNombre": "Ejemplo Actualizado",
       "segundoNombre": "Ejemplo2 Actualizado",
       "email": "ejemplo.actualizado@correo.com"
     }
     ```
   - Haz clic en "Send" para actualizar los datos del estudiante.

6. **Eliminar un estudiante:**
   - **Método:** DELETE  
   - **URL:** `http://localhost:8080/api/v1/student/1`  
     (Reemplaza `1` por el ID del estudiante que deseas eliminar)
   - Haz clic en "Send" y verifica que la respuesta sea un código 204 No Content.



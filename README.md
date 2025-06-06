# 🏫 Proyecto Spring Escuela

Este es un proyecto de **ejemplo básico** desarrollado con **Spring Boot**, que permite realizar operaciones CRUD sobre **Estudiantes**, **Profesores** y **Cursos**, utilizando una base de datos **MySQL**. También incluye documentación automática con **Swagger UI**.

---

## 🚀 Tecnologías Utilizadas

- Java 17  
- Spring Boot 3.5.0  
- Spring Web  
- Spring Data JPA  
- Spring Security (usado para redirección)  
- MySQL  
- Maven  
- Swagger (OpenAPI 3)  
- Postman  
- XAMPP (para MySQL local)

---

## ⚙️ Requisitos Previos

- Java 17 instalado  
- MySQL ejecutándose (puedes usar XAMPP u otro servidor)  
- Una base de datos llamada `escuela`  
- Maven instalado o un IDE como IntelliJ, Eclipse o VSCode

---

## 🔧 Configuración del Proyecto

1. Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tu-usuario/spring-escuela.git
Abre el proyecto con tu IDE favorito.

Configura el archivo src/main/resources/application.properties con tus credenciales de MySQL. Asegúrate de que el puerto (por defecto 3306), el usuario y la contraseña coincidan con tu configuración local.

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/escuela
spring.datasource.username=coloca_tu_usuario_aqui
spring.datasource.password=coloca_tu_contraseña_aqui
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Swagger config
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
▶️ ¿Cómo funciona?
El proyecto expone una API REST básica para 3 entidades:

Estudiante

Profesor

Curso

Puedes realizar operaciones básicas (GET, POST, DELETE, etc.) usando herramientas como Postman o directamente desde Swagger.

🌐 Endpoints por entidad
Entidad	Ruta Base	Operaciones Disponibles
Estudiantes	/estudiantes	GET, POST, GET /{id}, POST /{id}, DELETE /{id}
Profesores	/profesores	GET, POST, GET /{id}, DELETE /{id}
Cursos	/curso	GET, POST, GET /{id}, DELETE /{id}

📘 Acceso a Swagger UI
Cuando ejecutas el proyecto, accede al navegador en:

bash
Copy
Edit
http://localhost:8080/index
La ruta /index te redirige automáticamente a Swagger UI en:

bash
Copy
Edit
http://localhost:8080/swagger-ui.html
Desde Swagger puedes probar fácilmente todos los endpoints con ejemplos y formularios interactivos.

🧪 Probar con Postman
También puedes hacer pruebas manuales con Postman. Usa las siguientes rutas:

GET http://localhost:8080/estudiantes

POST http://localhost:8080/estudiantes (con JSON en el body)

GET http://localhost:8080/estudiantes/1

POST http://localhost:8080/estudiantes/1 (para actualizar)

DELETE http://localhost:8080/estudiantes/1

📁 Estructura del Proyecto
text
Copy
Edit
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── controller/    # Controladores REST
│   │       ├── entity/        # Entidades JPA
│   │       └── repository/    # Repositorios JPA
│   └── resources/
│       ├── application.properties  # Configuración de base de datos y Swagger
│       └── static/index.html       # Redirección a Swagger
📄 Código de Redirección a Swagger (index.html)
El archivo src/main/resources/static/index.html sirve para redirigir automáticamente al usuario a Swagger UI:

html
Copy
Edit
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="refresh" content="0; URL='swagger-ui.html'" />
  </head>
  <body></body>
</html>
🧠 Notas Finales
Este proyecto es solo un ejemplo educativo básico.

No incluye relaciones entre entidades ni seguridad real.

Puedes mejorarlo con autenticación JWT, DTOs, manejo global de errores, paginación, etc.

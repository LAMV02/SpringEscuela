🏫 Proyecto Spring Escuela
Este es un proyecto de ejemplo básico desarrollado con Spring Boot, que permite realizar operaciones CRUD sobre Estudiantes, Profesores y Cursos, utilizando una base de datos MySQL. También incluye documentación automática con Swagger.

🚀 Tecnologías Utilizadas
Java 17

Spring Boot 3.5.0

Spring Web

Spring Data JPA

Spring Security (solo para redirección al index)

MySQL

Maven

Swagger (OpenAPI)

Postman

XAMPP (servidor MySQL local)

⚙️ Requisitos Previos
Tener Java 17 instalado

Tener MySQL corriendo (por ejemplo, desde XAMPP)

Tener una base de datos llamada escuela

Tener Maven instalado o usar un IDE como IntelliJ o VSCode con soporte para Spring

🔧 Configuración
Clona el repositorio

Configura el archivo src/main/resources/application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/escuela
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
⚠️ Asegúrate de reemplazar el puerto y las credenciales si son distintas en tu entorno local.

▶️ ¿Cómo funciona?
El programa tiene 3 entidades principales:

Estudiante (/estudiantes)

Profesor (/profesores)

Curso (/curso)

Cada una de ellas cuenta con su respectivo controlador REST que permite:

Obtener todos los registros

Obtener por ID

Crear nuevos registros

Eliminar registros

(En algunos casos) Actualizar registros

Ejemplo de flujo:
Puedes usar herramientas como Postman o directamente probar los endpoints desde Swagger.

📑 Acceder a la documentación Swagger
Este proyecto redirige automáticamente desde /index a la documentación de Swagger.

Pasos:
Inicia la aplicación (mvn spring-boot:run o desde tu IDE)

Abre tu navegador y ve a:

bash
Copy
Edit
http://localhost:8080/index
Serás redirigido a:

bash
Copy
Edit
http://localhost:8080/swagger-ui/index.html
Allí podrás visualizar y probar todos los endpoints disponibles de forma interactiva.

📘 Notas
Este proyecto es solo un ejemplo educativo para aprender los fundamentos de Spring Boot, JPA y Swagger.

No incluye autenticación real ni manejo avanzado de errores.

Puedes extenderlo agregando validaciones más complejas, relaciones bidireccionales, o seguridad JWT.

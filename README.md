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
```
Abre el proyecto con tu IDE favorito.

Configura el archivo src/main/resources/application.properties con tus credenciales de MySQL. Asegúrate de que el puerto (por defecto 3306), el usuario y la contraseña coincidan con tu configuración local.


```bash
spring.datasource.url=jdbc:mysql://localhost:3306/escuela
spring.datasource.username=coloca_tu_usuario_aqui
spring.datasource.password=coloca_tu_contraseña_aqui
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

▶️ ¿Cómo funciona?
El proyecto expone una API REST básica para 3 entidades:

Estudiante

Profesor

Curso

Puedes realizar operaciones básicas (GET, POST, DELETE, etc.) usando herramientas como Postman o directamente desde Swagger.


📘 Acceso a Swagger UI
Cuando ejecutas el proyecto, accede al navegador en:

```bash
http://localhost:8080/index
La ruta /index te redirige automáticamente a Swagger UI en:
```

🧪 Probar con Postman
También puedes hacer pruebas manuales con Postman. Usa las siguientes rutas:

📚 Estudiantes

```
| Método | URL                                      | Descripción                     |
| ------ | ---------------------------------------- | ------------------------------- |
| GET    | `http://localhost:8080/estudiantes`      | Obtener todos los estudiantes   |
| GET    | `http://localhost:8080/estudiantes/{id}` | Obtener un estudiante por ID    |
| POST   | `http://localhost:8080/estudiantes`      | Agregar un nuevo estudiante     |
| POST   | `http://localhost:8080/estudiantes/{id}` | Actualizar un estudiante por ID |
| DELETE | `http://localhost:8080/estudiantes/{id}` | Eliminar un estudiante por ID   |

```
🎓 Profesores
```
| Método | URL                                     | Descripción                  |
| ------ | --------------------------------------- | ---------------------------- |
| GET    | `http://localhost:8080/profesores`      | Obtener todos los profesores |
| GET    | `http://localhost:8080/profesores/{id}` | Obtener un profesor por ID   |
| POST   | `http://localhost:8080/profesores`      | Agregar un nuevo profesor    |
| DELETE | `http://localhost:8080/profesores/{id}` | Eliminar un profesor por ID  |
```
🏫 Cursos
```
| Método | URL                                | Descripción               |
| ------ | ---------------------------------- | ------------------------- |
| GET    | `http://localhost:8080/curso`      | Obtener todos los cursos  |
| GET    | `http://localhost:8080/curso/{id}` | Obtener un curso por ID   |
| POST   | `http://localhost:8080/curso`      | Agregar un nuevo curso    |
| DELETE | `http://localhost:8080/curso/{id}` | Eliminar un curso por ID  |
| DELETE | `http://localhost:8080/curso`      | Eliminar todos los cursos |

```

🧠 Notas Finales
Este proyecto es solo un ejemplo educativo básico.

No incluye relaciones entre entidades ni seguridad real.


# 🏫 Proyecto Spring Escuela

Este es un proyecto de ejemplo desarrollado con **Spring Boot**, que permite realizar operaciones CRUD sobre estudiantes, almacenados en una base de datos **MySQL**.

## 🚀 Tecnologías Utilizadas

- Java 17  
- Spring Boot 3.5.0  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- MySQL  
- Maven  
- Postman  
- Swagger  
- XAMPP (servidor MySQL local)

## ⚙️ Requisitos Previos

- Tener Java 17 instalado  
- Tener MySQL corriendo (por ejemplo, desde XAMPP)  
- Tener una base de datos llamada `escuela`  
- Tener Maven instalado o usar un IDE como IntelliJ o VSCode con soporte para Spring

## 🔧 Configuración

1. Clona el repositorio  
2. Configura el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:[0000]/escuela
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

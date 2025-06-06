package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; //Validaciones con @Valid, import


@Entity  //	Marca la clase como una entidad JPA (será una tabla en la BD).
public class Estudiante {

    //Atributos de la clase Estudiante.
    @Id //Define el campo como clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que el ID será autogenerado por la base de datos.
    private Long id;

    @NotBlank   //Validaciones con @Valid
    private String nombre;

    @Min(1)
    @Max(120)
    private int edad;

    @NotBlank
    private String matricula;


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

            this.edad = edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}

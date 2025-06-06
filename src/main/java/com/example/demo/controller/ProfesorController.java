package com.example.demo.controller;

import com.example.demo.entity.Profesor;
import com.example.demo.repository.ProfesorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Profesores")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Operation(summary = "Obtener todos los profesores")
    @GetMapping
    public List<Profesor> obtenertodos(){
        return profesorRepository.findAll();
    }

    @Operation(summary = "Obtener un profesor por ID")
    @GetMapping("/{id}")
    public Profesor obtenerPorID(@PathVariable Long id){
        return profesorRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "Agregar un nuevo profesor",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Profesor.class),
                            examples = @ExampleObject(
                                    value = """
                    {
                      "nombre": "Carlos López",
                      "departamento": "Matemáticas"
                    }
                    """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Profesor creado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos")
            }
    )
    @PostMapping
    public Profesor agregar(@Valid @RequestBody Profesor profesor){
        return profesorRepository.save(profesor);
    }

    @Operation(summary = "Eliminar un profesor por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        profesorRepository.deleteById(id);
    }
}

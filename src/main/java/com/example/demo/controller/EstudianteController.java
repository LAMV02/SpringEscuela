package com.example.demo.controller;

import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;
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
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Operation(summary = "Obtener todos los estudiantes")
    @GetMapping
    public List<Estudiante> obtenertodos(){
        return estudianteRepository.findAll();
    }

    @Operation(
            summary = "Agregar un nuevo estudiante",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Estudiante.class),
                            examples = @ExampleObject(
                                    value = """
                    {
                      "nombre": "Juan Perez",
                      "edad": 22,
                      "matricula": "A12345"
                    }
                    """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Estudiante creado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos")
            }
    )
    @PostMapping
    public Estudiante agregar(@Valid @RequestBody Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    @Operation(summary = "Obtener un estudiante por ID")
    @GetMapping("/{id}")
    public Estudiante obtenerPorID(@PathVariable Long id){
        return estudianteRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "Actualizar un estudiante por ID",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Estudiante.class),
                            examples = @ExampleObject(
                                    value = """
                    {
                      "nombre": "Juan Perez Actualizado",
                      "edad": 23,
                      "matricula": "A12345"
                    }
                    """
                            )
                    )
            )
    )
    @PostMapping("/{id}")
    public Estudiante actualizar(@Valid @PathVariable Long id , @RequestBody Estudiante datos){
        Estudiante est = estudianteRepository.findById(id).orElse(null);
        if(est != null){
            est.setNombre(datos.getNombre());
            est.setEdad(datos.getEdad());
            est.setMatricula(datos.getMatricula());
            return estudianteRepository.save(est);
        }
        return null;
    }

    @Operation(summary = "Eliminar un estudiante por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        estudianteRepository.deleteById(id);
    }
}

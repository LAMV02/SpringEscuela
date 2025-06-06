package com.example.demo.controller;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Estudiante;
import com.example.demo.entity.Profesor;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.ProfesorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Operation(
            summary = "Agregar Curso",
            description = "Crea un nuevo curso asignando un profesor existente y una lista de estudiantes existentes",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class),
                            examples = @ExampleObject(
                                    value = """
                    {
                      "nombreDelCurso": "Programación en Java",
                      "profesor": {
                        "id": 1
                      },
                      "estudiantes": [
                        { "id": 1 },
                        { "id": 2 }
                      ]
                    }
                    """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Curso creado correctamente"),
                    @ApiResponse(responseCode = "404", description = "Profesor o estudiante no encontrado")
            }
    )
    @PostMapping
    public Curso agregar(@Valid @org.springframework.web.bind.annotation.RequestBody Curso curso) {
        // Validar y obtener profesor persistido
        Profesor profesorExistente = profesorRepository.findById(curso.getProfesor().getId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        curso.setProfesor(profesorExistente);

        // Validar y obtener estudiantes persistidos
        List<Estudiante> estudiantesPersistidos = new ArrayList<>();
        for (Estudiante e : curso.getEstudiantes()) {
            Estudiante est = estudianteRepository.findById(e.getId())
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado: " + e.getId()));
            estudiantesPersistidos.add(est);
        }
        curso.setEstudiantes(estudiantesPersistidos);

        return cursoRepository.save(curso);
    }

    @Operation(summary = "Obtener todos los cursos")
    @GetMapping
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Operation(summary = "Obtener curso por ID")
    @GetMapping("/{id}")
    public Curso obtenerPorID(@PathVariable Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Eliminar curso por ID")
    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }

    @Operation(summary = "Eliminar todos los cursos")
    @DeleteMapping
    public void borrarTodos() {
        cursoRepository.deleteAll();
    }
}

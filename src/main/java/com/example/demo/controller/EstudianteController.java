package com.example.demo.controller;

import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    //Obtener todos los estudiantes
    public List<Estudiante> obtenertodos(){
        return estudianteRepository.findAll();
    }
    //Agregar un nuevo estuidante
    @PostMapping
    public Estudiante agregar(@Valid @RequestBody Estudiante estudiante){return estudianteRepository.save(estudiante);
    }

    //Obtener un estudiante por ID
    @GetMapping("/{id}")
    public Estudiante obtenerPorID(@PathVariable Long id){
        return estudianteRepository.findById(id).orElse(null);
    }

    //Actualizar un estudiante por ID
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

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
         estudianteRepository.deleteById(id);
    }



}

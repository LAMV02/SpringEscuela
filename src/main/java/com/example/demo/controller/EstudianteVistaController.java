package com.example.demo.controller;

import com.example.demo.entity.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EstudianteVistaController {

    private final  EstudianteRepository estudianteRepository;

    public EstudianteVistaController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @GetMapping("/vista/estudiantes")
    public String verEstudiantes (Model model){
        List<Estudiante>  estudiantes = estudianteRepository.findAll();
        model.addAttribute("estudiantes",estudiantes);
        return "estudiantes"; // Esto buscará estudiantes.html en templates
    }



    @PostMapping("/vista/estudiantes/agregar")
    public String agregarEstudiante(@RequestParam String nombre, @RequestParam int edad, @RequestParam String matricula) {

           Estudiante e = new Estudiante();
           e.setNombre(nombre);
           e.setEdad(edad);
           e.setMatricula(matricula);
           estudianteRepository.save(e);
           
        return "redirect:/vista/estudiantes";
    }

    @GetMapping("/vista/estudiantes/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
        return "redirect:/vista/estudiantes";
    }
}

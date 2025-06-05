package com.example.demo.controller;

import com.example.demo.entity.Profesor;
import com.example.demo.repository.ProfesorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Profesores")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @GetMapping
    public List<Profesor> obtenertodos(){
        return profesorRepository.findAll();
    }

    @PostMapping
    public Profesor agregar(@Valid @RequestBody Profesor profesor){
        return profesorRepository.save(profesor);
    }

}

package com.example.demo.controller;

import com.example.demo.entity.Profesor;
import com.example.demo.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getAll(){
        return profesorRepository.findAll();
    }

}

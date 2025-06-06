package com.example.demo.repository;

import com.example.demo.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface ProfesorRepository extends JpaRepository <Profesor, Long> {
}

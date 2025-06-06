package com.example.demo.repository;

import com.example.demo.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //Marca la interfaz como un componente de acceso a datos. Spring la detecta automáticamente.
public interface EstudianteRepository extends JpaRepository <Estudiante, Long> { //	Le dice a Spring que esta interfaz manejará la entidad Estudiante y que el campo id es tipo Long.

}

package com.proyecto.proyectoWeb.repository;

import com.proyecto.proyectoWeb.models.Nota;
import com.proyecto.proyectoWeb.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface RepositoryNotas extends JpaRepository<Nota, Long> {


    @Query(value = "SELECT * FROM notas WHERE student_id = ?1", nativeQuery = true)
    public Optional<Nota> findByStudentId(int id);


}


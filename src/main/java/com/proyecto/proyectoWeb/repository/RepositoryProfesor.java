package com.proyecto.proyectoWeb.repository;

import com.proyecto.proyectoWeb.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryProfesor extends JpaRepository<Profesor, Long> {

    @Query(value = "SELECT * FROM profesores", nativeQuery = true)
    public List<Profesor> findAll();

    @Query(value = "SELECT * FROM profesores WHERE nombre = ?1 AND email = ?2", nativeQuery = true )
    Optional<Profesor> findProfesorByEvery(String name, String email);
}

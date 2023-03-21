package com.proyecto.proyectoWeb.repository;

import com.proyecto.proyectoWeb.models.Modulos;
import com.proyecto.proyectoWeb.models.Profesor;
import com.proyecto.proyectoWeb.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositoryModulos   extends JpaRepository<Modulos, Long> {
    @Transactional
    @Modifying
    @Query(value = "update modulos set profesor_id = ?2 where id = ?1", nativeQuery = true)
    void actualizarFKProfesor(int modulo_id, int profesor_id);

    @Query(value = "SELECT * FROM modulos", nativeQuery = true)
    public List<Modulos> findAll();

}

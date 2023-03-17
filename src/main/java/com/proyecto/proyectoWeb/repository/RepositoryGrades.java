package com.proyecto.proyectoWeb.repository;

import com.proyecto.proyectoWeb.models.Grades;
import com.proyecto.proyectoWeb.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RepositoryGrades  extends JpaRepository<Grades, Long> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO grades (lenguajes, entornos, student_id) values (:lenguajes, :entornos, :id);", nativeQuery = true)
    void gradeStudent(@Param("id") String id, @Param("lenguajes") int lenguajes, @Param("entornos") int entornos);


}

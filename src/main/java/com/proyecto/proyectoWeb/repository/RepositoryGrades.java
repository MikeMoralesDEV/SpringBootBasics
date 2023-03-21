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
    @Query(value="UPDATE students, grades SET students.grades_id = grades.ID WHERE students.id = grades.student_id; \n", nativeQuery = true)
    public void refreshGrades();


}

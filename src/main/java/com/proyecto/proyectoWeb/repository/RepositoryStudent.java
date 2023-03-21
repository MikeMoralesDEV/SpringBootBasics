package com.proyecto.proyectoWeb.repository;

import com.proyecto.proyectoWeb.models.Grades;
import com.proyecto.proyectoWeb.models.Student;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface RepositoryStudent extends JpaRepository<Student, Long> {


    @Query(value = "SELECT * FROM students", nativeQuery = true)
    public List<Student> findAll();

    @Query(value = "SELECT * FROM students WHERE ID = ?1", nativeQuery = true)
    public Optional<Student> findById(int id);

    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO students (first_name, last_name, email) values (:FirstName, :LastName, :email)",
            nativeQuery = true)
    void addStudent(@Param("FirstName") String first_name, @Param("LastName") String last_name,
                    @Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM students WHERE ID=:id", nativeQuery = true)
    void deleteStudent(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET first_name=:FirstName, last_name=:LastName, email=:email WHERE ID=:id", nativeQuery = true)
    void editStudent(@Param("id") int id, @Param("FirstName") String first_name, @Param("LastName") String last_name,
                     @Param("email") String email);


}


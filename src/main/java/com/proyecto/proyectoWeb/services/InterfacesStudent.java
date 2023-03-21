package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Student;
import java.util.List;
import java.util.Optional;

public interface InterfacesStudent {

    List<Student> getAllStudents();
    public Optional<Student> findById(int id);

    void addStudent(String first_name, String last_name, String email);
    void deleteStudent(int id);
    void editStudent(int id, String first_name, String last_name, String email);


}

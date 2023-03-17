package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Student;
import java.util.List;

public interface InterfacesStudent {

    List<Student> getAllStudents();
    public Student findById(String id);

    void addStudent(String first_name, String last_name, String email);
    void deleteStudent(String id);
    void editStudent(String id, String first_name, String last_name, String email);

    void refreshGrades();

}

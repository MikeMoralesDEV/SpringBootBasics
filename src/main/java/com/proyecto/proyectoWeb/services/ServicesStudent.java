package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Student;
import java.util.List;
import org.springframework.stereotype.Service;
import com.proyecto.proyectoWeb.repository.RepositoryStudent;

@Service
public class ServicesStudent implements InterfacesStudent {

    private RepositoryStudent studentRepository;

    public ServicesStudent(RepositoryStudent studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id){ return studentRepository.findById(id); }

    @Override
    public void addStudent(String first_name, String last_name, String email) { studentRepository.addStudent(first_name, last_name, email); }

    @Override
    public void deleteStudent(String id){ studentRepository.deleteStudent(id); }

    @Override
    public void editStudent(String id, String first_name, String last_name, String email){ studentRepository.editStudent(id, first_name, last_name, email); }

    @Override
    public void refreshGrades(){ studentRepository.refreshGrades();}

}

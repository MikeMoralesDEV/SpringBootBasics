package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Student;
import java.util.List;
import java.util.Optional;

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
    public Optional<Student> findById(int id){ return studentRepository.findById(id); }

    @Override
    public void addStudent(String first_name, String last_name, String email) { studentRepository.addStudent(first_name, last_name, email); }

    @Override
    public void deleteStudent(int id){ studentRepository.deleteStudent(id); }

    @Override
    public void editStudent(int id, String first_name, String last_name, String email){ studentRepository.editStudent(id, first_name, last_name, email); }



}

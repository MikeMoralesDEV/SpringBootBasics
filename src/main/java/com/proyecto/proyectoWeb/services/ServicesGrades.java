package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Grades;
import com.proyecto.proyectoWeb.repository.RepositoryGrades;
import org.springframework.stereotype.Service;

@Service
public class ServicesGrades implements InterfacesGrades{

    private RepositoryGrades gradesRepository;

    public ServicesGrades(RepositoryGrades gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @Override
    public void gradeStudent(Grades grade){ gradesRepository.save(grade); }

    @Override
    public void refreshGrades(){ gradesRepository.refreshGrades();}



}

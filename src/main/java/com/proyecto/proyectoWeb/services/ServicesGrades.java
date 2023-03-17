package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.repository.RepositoryGrades;
import org.springframework.stereotype.Service;

@Service
public class ServicesGrades implements InterfacesGrades{

    private RepositoryGrades gradesRepository;

    public ServicesGrades(RepositoryGrades gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @Override
    public void gradeStudent(String id, int lenguajes, int entornos){ gradesRepository.gradeStudent(id, lenguajes, entornos); }

    @Override
    public void refreshGrades(){ gradesRepository.refreshGrades();}

}

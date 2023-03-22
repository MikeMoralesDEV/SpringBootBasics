package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Nota;
import com.proyecto.proyectoWeb.repository.RepositoryNotas;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicesNotas implements InterfacesNotas{

    private RepositoryNotas repositoryNotas;

    public ServicesNotas(RepositoryNotas repositoryNotas) {
        this.repositoryNotas = repositoryNotas;
    }

    @Override
    public Optional<Nota> findByStudentId(int id){ return repositoryNotas.findByStudentId(id); }

    public void save(Nota nota){ repositoryNotas.save(nota); }






}

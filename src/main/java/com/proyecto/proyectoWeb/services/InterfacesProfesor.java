package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Profesor;

import java.util.List;
import java.util.Optional;

public interface InterfacesProfesor {

    public List<Profesor> findAll();

    Optional<Profesor> findProfesorByEvery(String name, String email);


}

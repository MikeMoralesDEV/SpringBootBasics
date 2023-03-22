package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Grades;
import com.proyecto.proyectoWeb.models.Nota;

import java.util.Optional;

public interface InterfacesNotas {

    public Optional<Nota> findByStudentId(int id);


}

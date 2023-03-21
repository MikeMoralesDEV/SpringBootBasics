package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Modulos;

import java.util.List;

public interface InterfacesModulos {

    public List<Modulos> findAll();

    void actualizarFKProfesor(int modulo_id, int profesor_id);


}

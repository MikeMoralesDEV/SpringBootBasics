package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Modulos;
import com.proyecto.proyectoWeb.models.Profesor;
import com.proyecto.proyectoWeb.models.Student;
import com.proyecto.proyectoWeb.repository.RepositoryModulos;
import com.proyecto.proyectoWeb.repository.RepositoryProfesor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesProfesor implements InterfacesProfesor {


    RepositoryProfesor repositoryProfesor;
    RepositoryModulos repositoryModulos;
    public ServicesProfesor(RepositoryProfesor repositoryProfesor, RepositoryModulos repositoryModulos) {
        this.repositoryProfesor = repositoryProfesor;
        this.repositoryModulos = repositoryModulos;
    }


    @Override
    public List<Profesor> findAll(){
        return repositoryProfesor.findAll();
    }

    @Override
    public Optional<Profesor> findProfesorByEvery(String name, String email){
        return repositoryProfesor.findProfesorByEvery(name, email);
    }


    public void save(Profesor profesor){
        // Update FK Modulos
        List<Modulos> modulos = profesor.getModulos();
        repositoryProfesor.save(profesor);
        Optional<Profesor> aux = repositoryProfesor.findProfesorByEvery(profesor.getNombre(), profesor.getEmail());
        Profesor profesorActual = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        for (Modulos modulo : modulos) {
            repositoryModulos.actualizarFKProfesor(modulo.getId(), profesorActual.getId());
        }
    }

}
